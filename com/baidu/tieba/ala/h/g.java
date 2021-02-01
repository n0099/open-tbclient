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
public class g implements com.baidu.live.t.b {
    private static final String ifC = com.baidu.live.storage.b.QR();
    private static final String ifD = com.baidu.live.storage.b.QW();
    private static final String ifE = com.baidu.live.storage.b.Ra();
    private boolean ifF;
    private HttpMessageListener ifG;
    private String ifI;
    private h igJ;

    public static g coO() {
        return a.igL;
    }

    public String cox() {
        return this.ifI;
    }

    @Override // com.baidu.live.t.b
    public void Pj() {
        final ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar == null || arVar.aNp == null || TextUtils.isEmpty(arVar.aNp.downloadUrl)) {
            bWF();
        } else if (!this.ifF) {
            this.ifI = "";
            this.ifF = true;
            new BdAsyncTask<cb, Void, cb>() { // from class: com.baidu.tieba.ala.h.g.1
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
                    String string = com.baidu.live.d.xc().getString("live_pk_rank_kill_anim", "");
                    if (TextUtils.isEmpty(string) || (Iv = f.Iv(string)) == null || !cbVar.downloadUrl.equals(Iv.downloadUrl) || !cbVar.aQJ.equals(Iv.aQJ) || TextUtils.isEmpty(Iv.videoMd5) || !Iv.videoMd5.equals(g.this.coy())) {
                        g.this.coz();
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
                        g.this.a(arVar.aNp);
                        return;
                    }
                    g.this.ifI = cbVar.videoPath;
                }
            }.execute(arVar.aNp);
        }
    }

    @Override // com.baidu.live.t.b
    public void release() {
        this.ifF = false;
        this.ifI = "";
        MessageManager.getInstance().unRegisterListener(this.ifG);
        this.ifG = null;
        if (this.igJ != null) {
            this.igJ.release();
        }
        com.baidu.live.h.b.cE(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cb> list) {
        if (list != null && !list.isEmpty()) {
            cb cbVar = list.get(0);
            this.ifI = cbVar.videoPath;
            com.baidu.live.d.xc().putString("live_pk_rank_kill_anim", f.c(cbVar));
        }
    }

    private void bWF() {
        if (this.ifG == null) {
            this.ifG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.g.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        g.this.Pj();
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
            this.igJ = new h();
            this.igJ.y(cbVar.downloadUrl, cbVar.aQJ, ifD, ifE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coz() {
        this.ifI = "";
        com.baidu.live.d.xc().putString("live_pk_rank_kill_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ifC));
    }

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static g igL = new g();
    }
}
