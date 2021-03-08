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
/* loaded from: classes10.dex */
public class k implements com.baidu.live.t.e {
    private boolean ihC;
    private HttpMessageListener ihD;
    private String ihF;
    private l iiN;
    private static final String ihz = com.baidu.live.storage.b.QT();
    private static final String ihA = com.baidu.live.storage.b.QY();
    private static final String ihB = com.baidu.live.storage.b.Rg();

    public static k cpd() {
        return a.iiP;
    }

    public String coK() {
        return this.ihF;
    }

    @Override // com.baidu.live.t.e
    public void Pm() {
        final ar arVar = com.baidu.live.ae.a.Qm().bwx;
        if (arVar == null || arVar.aON == null || TextUtils.isEmpty(arVar.aON.downloadUrl)) {
            bWS();
        } else if (!this.ihC) {
            this.ihF = "";
            this.ihC = true;
            new BdAsyncTask<cc, Void, cc>() { // from class: com.baidu.tieba.ala.h.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public cc doInBackground(cc... ccVarArr) {
                    cc IG;
                    if (ccVarArr == null || ccVarArr.length == 0) {
                        return null;
                    }
                    cc ccVar = ccVarArr[0];
                    String string = com.baidu.live.d.xf().getString("live_pk_rank_start_anim", "");
                    if (TextUtils.isEmpty(string) || (IG = j.IG(string)) == null || !ccVar.downloadUrl.equals(IG.downloadUrl) || !ccVar.aSj.equals(IG.aSj) || TextUtils.isEmpty(IG.videoMd5) || !IG.videoMd5.equals(k.this.coL())) {
                        k.this.coM();
                        return null;
                    }
                    return IG;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(cc ccVar) {
                    super.onPostExecute(ccVar);
                    if (ccVar == null) {
                        k.this.b(arVar.aON);
                        return;
                    }
                    k.this.ihF = ccVar.videoPath;
                }
            }.execute(arVar.aON);
        }
    }

    @Override // com.baidu.live.t.e
    public void release() {
        this.ihC = false;
        this.ihF = "";
        MessageManager.getInstance().unRegisterListener(this.ihD);
        this.ihD = null;
        if (this.iiN != null) {
            this.iiN.release();
        }
        com.baidu.live.h.b.cF(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cc> list) {
        if (list != null && !list.isEmpty()) {
            cc ccVar = list.get(0);
            this.ihF = ccVar.videoPath;
            com.baidu.live.d.xf().putString("live_pk_rank_start_anim", j.a(ccVar));
        }
    }

    private void bWS() {
        if (this.ihD == null) {
            this.ihD = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.k.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        k.this.Pm();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ihD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String coL() {
        File[] listFiles = new File(ihB).listFiles();
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
            this.iiN = new l();
            this.iiN.y(ccVar.downloadUrl, ccVar.aSj, ihA, ihB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coM() {
        this.ihF = "";
        com.baidu.live.d.xf().putString("live_pk_rank_start_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ihz));
    }

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static k iiP = new k();
    }
}
