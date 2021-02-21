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
    private static final String ifQ = com.baidu.live.storage.b.QQ();
    private static final String ifR = com.baidu.live.storage.b.QV();
    private static final String ifS = com.baidu.live.storage.b.Rd();
    private boolean ifT;
    private HttpMessageListener ifU;
    private String ifW;
    private l ihe;

    public static k coX() {
        return a.ihg;
    }

    public String coE() {
        return this.ifW;
    }

    @Override // com.baidu.live.t.e
    public void Pj() {
        final ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar == null || arVar.aNn == null || TextUtils.isEmpty(arVar.aNn.downloadUrl)) {
            bWM();
        } else if (!this.ifT) {
            this.ifW = "";
            this.ifT = true;
            new BdAsyncTask<cc, Void, cc>() { // from class: com.baidu.tieba.ala.h.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public cc doInBackground(cc... ccVarArr) {
                    cc Ix;
                    if (ccVarArr == null || ccVarArr.length == 0) {
                        return null;
                    }
                    cc ccVar = ccVarArr[0];
                    String string = com.baidu.live.d.xc().getString("live_pk_rank_start_anim", "");
                    if (TextUtils.isEmpty(string) || (Ix = j.Ix(string)) == null || !ccVar.downloadUrl.equals(Ix.downloadUrl) || !ccVar.aQJ.equals(Ix.aQJ) || TextUtils.isEmpty(Ix.videoMd5) || !Ix.videoMd5.equals(k.this.coF())) {
                        k.this.coG();
                        return null;
                    }
                    return Ix;
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
                    k.this.ifW = ccVar.videoPath;
                }
            }.execute(arVar.aNn);
        }
    }

    @Override // com.baidu.live.t.e
    public void release() {
        this.ifT = false;
        this.ifW = "";
        MessageManager.getInstance().unRegisterListener(this.ifU);
        this.ifU = null;
        if (this.ihe != null) {
            this.ihe.release();
        }
        com.baidu.live.h.b.cE(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cc> list) {
        if (list != null && !list.isEmpty()) {
            cc ccVar = list.get(0);
            this.ifW = ccVar.videoPath;
            com.baidu.live.d.xc().putString("live_pk_rank_start_anim", j.a(ccVar));
        }
    }

    private void bWM() {
        if (this.ifU == null) {
            this.ifU = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.k.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        k.this.Pj();
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
    public void b(cc ccVar) {
        if (ccVar != null && !TextUtils.isEmpty(ccVar.downloadUrl)) {
            this.ihe = new l();
            this.ihe.y(ccVar.downloadUrl, ccVar.aQJ, ifR, ifS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coG() {
        this.ifW = "";
        com.baidu.live.d.xc().putString("live_pk_rank_start_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ifQ));
    }

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static k ihg = new k();
    }
}
