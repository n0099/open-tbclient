package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.ar;
import com.baidu.live.data.cc;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import java.io.File;
import java.util.List;
/* loaded from: classes11.dex */
public class k implements com.baidu.live.t.e {
    private static final String ifC = com.baidu.live.storage.b.QQ();
    private static final String ifD = com.baidu.live.storage.b.QV();
    private static final String ifE = com.baidu.live.storage.b.Rd();
    private boolean ifF;
    private HttpMessageListener ifG;
    private String ifI;
    private l igQ;

    public static k coQ() {
        return a.igS;
    }

    public String cox() {
        return this.ifI;
    }

    @Override // com.baidu.live.t.e
    public void Pj() {
        final ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar == null || arVar.aNn == null || TextUtils.isEmpty(arVar.aNn.downloadUrl)) {
            bWF();
        } else if (!this.ifF) {
            this.ifI = "";
            this.ifF = true;
            new BdAsyncTask<cc, Void, cc>() { // from class: com.baidu.tieba.ala.h.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public cc doInBackground(cc... ccVarArr) {
                    cc Iw;
                    if (ccVarArr == null || ccVarArr.length == 0) {
                        return null;
                    }
                    cc ccVar = ccVarArr[0];
                    String string = com.baidu.live.d.xc().getString("live_pk_rank_start_anim", "");
                    if (TextUtils.isEmpty(string) || (Iw = j.Iw(string)) == null || !ccVar.downloadUrl.equals(Iw.downloadUrl) || !ccVar.aQJ.equals(Iw.aQJ) || TextUtils.isEmpty(Iw.videoMd5) || !Iw.videoMd5.equals(k.this.coy())) {
                        k.this.coz();
                        return null;
                    }
                    return Iw;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(cc ccVar) {
                    super.onPostExecute(ccVar);
                    if (ccVar == null) {
                        k.this.b(arVar.aNn);
                        return;
                    }
                    k.this.ifI = ccVar.videoPath;
                }
            }.execute(arVar.aNn);
        }
    }

    @Override // com.baidu.live.t.e
    public void release() {
        this.ifF = false;
        this.ifI = "";
        MessageManager.getInstance().unRegisterListener(this.ifG);
        this.ifG = null;
        if (this.igQ != null) {
            this.igQ.release();
        }
        com.baidu.live.h.b.cE(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cc> list) {
        if (list != null && !list.isEmpty()) {
            cc ccVar = list.get(0);
            this.ifI = ccVar.videoPath;
            com.baidu.live.d.xc().putString("live_pk_rank_start_anim", j.a(ccVar));
        }
    }

    private void bWF() {
        if (this.ifG == null) {
            this.ifG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.k.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        k.this.Pj();
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
    public void b(cc ccVar) {
        if (ccVar != null && !TextUtils.isEmpty(ccVar.downloadUrl)) {
            this.igQ = new l();
            this.igQ.y(ccVar.downloadUrl, ccVar.aQJ, ifD, ifE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coz() {
        this.ifI = "";
        com.baidu.live.d.xc().putString("live_pk_rank_start_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ifC));
    }

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static k igS = new k();
    }
}
