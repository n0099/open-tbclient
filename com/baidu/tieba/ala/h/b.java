package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.ar;
import com.baidu.live.data.cb;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import java.io.File;
import java.util.List;
/* loaded from: classes11.dex */
public class b implements com.baidu.live.t.b {
    private static final String ifQ = com.baidu.live.storage.b.QS();
    private static final String ifR = com.baidu.live.storage.b.QX();
    private static final String ifS = com.baidu.live.storage.b.Rb();
    private boolean ifT;
    private HttpMessageListener ifU;
    private String ifW;
    private c igO;

    public static b coT() {
        return a.igQ;
    }

    public String coE() {
        return this.ifW;
    }

    @Override // com.baidu.live.t.b
    public void Pj() {
        final ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar == null || arVar.aNq == null || TextUtils.isEmpty(arVar.aNq.downloadUrl)) {
            bWM();
        } else if (!this.ifT) {
            this.ifW = "";
            this.ifT = true;
            new BdAsyncTask<cb, Void, cb>() { // from class: com.baidu.tieba.ala.h.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public cb doInBackground(cb... cbVarArr) {
                    cb Iw;
                    if (cbVarArr == null || cbVarArr.length == 0) {
                        return null;
                    }
                    cb cbVar = cbVarArr[0];
                    String string = com.baidu.live.d.xc().getString("live_pk_rank_anti_kill_anim", "");
                    if (TextUtils.isEmpty(string) || (Iw = f.Iw(string)) == null || !cbVar.downloadUrl.equals(Iw.downloadUrl) || !cbVar.aQJ.equals(Iw.aQJ) || TextUtils.isEmpty(Iw.videoMd5) || !Iw.videoMd5.equals(b.this.coF())) {
                        b.this.coG();
                        return null;
                    }
                    return Iw;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: b */
                public void onPostExecute(cb cbVar) {
                    super.onPostExecute(cbVar);
                    if (cbVar == null) {
                        b.this.a(arVar.aNq);
                        return;
                    }
                    b.this.ifW = cbVar.videoPath;
                }
            }.execute(arVar.aNq);
        }
    }

    @Override // com.baidu.live.t.b
    public void release() {
        this.ifT = false;
        this.ifW = "";
        MessageManager.getInstance().unRegisterListener(this.ifU);
        this.ifU = null;
        if (this.igO != null) {
            this.igO.release();
        }
        com.baidu.live.h.b.cE(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cb> list) {
        if (list != null && !list.isEmpty()) {
            cb cbVar = list.get(0);
            this.ifW = cbVar.videoPath;
            com.baidu.live.d.xc().putString("live_pk_rank_anti_kill_anim", f.c(cbVar));
        }
    }

    private void bWM() {
        if (this.ifU == null) {
            this.ifU = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        b.this.Pj();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ifU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String coF() {
        File[] listFiles = new File(ifS).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        for (File file : listFiles) {
            if (!file.isDirectory()) {
                return com.baidu.live.h.a.getFileMd5(file);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cb cbVar) {
        if (cbVar != null && !TextUtils.isEmpty(cbVar.downloadUrl)) {
            this.igO = new c();
            this.igO.y(cbVar.downloadUrl, cbVar.aQJ, ifR, ifS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coG() {
        this.ifW = "";
        com.baidu.live.d.xc().putString("live_pk_rank_anti_kill_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ifQ));
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static b igQ = new b();
    }
}
