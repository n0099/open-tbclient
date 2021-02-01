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
    private static final String ifC = com.baidu.live.storage.b.QS();
    private static final String ifD = com.baidu.live.storage.b.QX();
    private static final String ifE = com.baidu.live.storage.b.Rb();
    private boolean ifF;
    private HttpMessageListener ifG;
    private String ifI;
    private c igA;

    public static b coM() {
        return a.igC;
    }

    public String cox() {
        return this.ifI;
    }

    @Override // com.baidu.live.t.b
    public void Pj() {
        final ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar == null || arVar.aNq == null || TextUtils.isEmpty(arVar.aNq.downloadUrl)) {
            bWF();
        } else if (!this.ifF) {
            this.ifI = "";
            this.ifF = true;
            new BdAsyncTask<cb, Void, cb>() { // from class: com.baidu.tieba.ala.h.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public cb doInBackground(cb... cbVarArr) {
                    cb Iv;
                    if (cbVarArr == null || cbVarArr.length == 0) {
                        return null;
                    }
                    cb cbVar = cbVarArr[0];
                    String string = com.baidu.live.d.xc().getString("live_pk_rank_anti_kill_anim", "");
                    if (TextUtils.isEmpty(string) || (Iv = f.Iv(string)) == null || !cbVar.downloadUrl.equals(Iv.downloadUrl) || !cbVar.aQJ.equals(Iv.aQJ) || TextUtils.isEmpty(Iv.videoMd5) || !Iv.videoMd5.equals(b.this.coy())) {
                        b.this.coz();
                        return null;
                    }
                    return Iv;
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
                    b.this.ifI = cbVar.videoPath;
                }
            }.execute(arVar.aNq);
        }
    }

    @Override // com.baidu.live.t.b
    public void release() {
        this.ifF = false;
        this.ifI = "";
        MessageManager.getInstance().unRegisterListener(this.ifG);
        this.ifG = null;
        if (this.igA != null) {
            this.igA.release();
        }
        com.baidu.live.h.b.cE(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cb> list) {
        if (list != null && !list.isEmpty()) {
            cb cbVar = list.get(0);
            this.ifI = cbVar.videoPath;
            com.baidu.live.d.xc().putString("live_pk_rank_anti_kill_anim", f.c(cbVar));
        }
    }

    private void bWF() {
        if (this.ifG == null) {
            this.ifG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        b.this.Pj();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ifG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String coy() {
        File[] listFiles = new File(ifE).listFiles();
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
            this.igA = new c();
            this.igA.y(cbVar.downloadUrl, cbVar.aQJ, ifD, ifE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coz() {
        this.ifI = "";
        com.baidu.live.d.xc().putString("live_pk_rank_anti_kill_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ifC));
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static b igC = new b();
    }
}
