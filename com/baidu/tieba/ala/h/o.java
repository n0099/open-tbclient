package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.ar;
import com.baidu.live.data.cd;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import java.io.File;
import java.util.List;
/* loaded from: classes10.dex */
public class o implements com.baidu.live.t.f {
    private boolean ihC;
    private HttpMessageListener ihD;
    private String ihF;
    private p iiT;
    private static final String ihz = com.baidu.live.storage.b.QW();
    private static final String ihA = com.baidu.live.storage.b.Rb();
    private static final String ihB = com.baidu.live.storage.b.Rf();

    public static o cpg() {
        return a.iiV;
    }

    public String coK() {
        return this.ihF;
    }

    @Override // com.baidu.live.t.f
    public void Pm() {
        final ar arVar = com.baidu.live.ae.a.Qm().bwx;
        if (arVar == null || arVar.aOO == null || TextUtils.isEmpty(arVar.aOO.downloadUrl)) {
            bWS();
        } else if (!this.ihC) {
            this.ihF = "";
            this.ihC = true;
            new BdAsyncTask<cd, Void, cd>() { // from class: com.baidu.tieba.ala.h.o.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public cd doInBackground(cd... cdVarArr) {
                    cd IH;
                    if (cdVarArr == null || cdVarArr.length == 0) {
                        return null;
                    }
                    cd cdVar = cdVarArr[0];
                    String string = com.baidu.live.d.xf().getString("live_pk_rank_task_anim", "");
                    if (TextUtils.isEmpty(string) || (IH = n.IH(string)) == null || !cdVar.downloadUrl.equals(IH.downloadUrl) || !cdVar.aSj.equals(IH.aSj) || TextUtils.isEmpty(IH.videoMd5) || !IH.videoMd5.equals(o.this.coL())) {
                        o.this.coM();
                        return null;
                    }
                    return IH;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(cd cdVar) {
                    super.onPostExecute(cdVar);
                    if (cdVar == null) {
                        o.this.b(arVar.aOO);
                        return;
                    }
                    o.this.ihF = cdVar.videoPath;
                }
            }.execute(arVar.aOO);
        }
    }

    @Override // com.baidu.live.t.f
    public void release() {
        this.ihC = false;
        this.ihF = "";
        MessageManager.getInstance().unRegisterListener(this.ihD);
        this.ihD = null;
        if (this.iiT != null) {
            this.iiT.release();
        }
        com.baidu.live.h.b.cF(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cd> list) {
        if (list != null && !list.isEmpty()) {
            cd cdVar = list.get(0);
            this.ihF = cdVar.videoPath;
            com.baidu.live.d.xf().putString("live_pk_rank_task_anim", n.a(cdVar));
        }
    }

    private void bWS() {
        if (this.ihD == null) {
            this.ihD = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.o.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        o.this.Pm();
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
    public void b(cd cdVar) {
        if (cdVar != null && !TextUtils.isEmpty(cdVar.downloadUrl)) {
            this.iiT = new p();
            this.iiT.y(cdVar.downloadUrl, cdVar.aSj, ihA, ihB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coM() {
        this.ihF = "";
        com.baidu.live.d.xf().putString("live_pk_rank_task_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ihz));
    }

    private o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static o iiV = new o();
    }
}
