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
/* loaded from: classes11.dex */
public class o implements com.baidu.live.t.f {
    private static final String ifQ = com.baidu.live.storage.b.QT();
    private static final String ifR = com.baidu.live.storage.b.QY();
    private static final String ifS = com.baidu.live.storage.b.Rc();
    private boolean ifT;
    private HttpMessageListener ifU;
    private String ifW;
    private p ihk;

    public static o cpa() {
        return a.ihm;
    }

    public String coE() {
        return this.ifW;
    }

    @Override // com.baidu.live.t.f
    public void Pj() {
        final ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar == null || arVar.aNo == null || TextUtils.isEmpty(arVar.aNo.downloadUrl)) {
            bWM();
        } else if (!this.ifT) {
            this.ifW = "";
            this.ifT = true;
            new BdAsyncTask<cd, Void, cd>() { // from class: com.baidu.tieba.ala.h.o.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public cd doInBackground(cd... cdVarArr) {
                    cd Iy;
                    if (cdVarArr == null || cdVarArr.length == 0) {
                        return null;
                    }
                    cd cdVar = cdVarArr[0];
                    String string = com.baidu.live.d.xc().getString("live_pk_rank_task_anim", "");
                    if (TextUtils.isEmpty(string) || (Iy = n.Iy(string)) == null || !cdVar.downloadUrl.equals(Iy.downloadUrl) || !cdVar.aQJ.equals(Iy.aQJ) || TextUtils.isEmpty(Iy.videoMd5) || !Iy.videoMd5.equals(o.this.coF())) {
                        o.this.coG();
                        return null;
                    }
                    return Iy;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(cd cdVar) {
                    super.onPostExecute(cdVar);
                    if (cdVar == null) {
                        o.this.b(arVar.aNo);
                        return;
                    }
                    o.this.ifW = cdVar.videoPath;
                }
            }.execute(arVar.aNo);
        }
    }

    @Override // com.baidu.live.t.f
    public void release() {
        this.ifT = false;
        this.ifW = "";
        MessageManager.getInstance().unRegisterListener(this.ifU);
        this.ifU = null;
        if (this.ihk != null) {
            this.ihk.release();
        }
        com.baidu.live.h.b.cE(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cd> list) {
        if (list != null && !list.isEmpty()) {
            cd cdVar = list.get(0);
            this.ifW = cdVar.videoPath;
            com.baidu.live.d.xc().putString("live_pk_rank_task_anim", n.a(cdVar));
        }
    }

    private void bWM() {
        if (this.ifU == null) {
            this.ifU = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.o.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        o.this.Pj();
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
    public void b(cd cdVar) {
        if (cdVar != null && !TextUtils.isEmpty(cdVar.downloadUrl)) {
            this.ihk = new p();
            this.ihk.y(cdVar.downloadUrl, cdVar.aQJ, ifR, ifS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coG() {
        this.ifW = "";
        com.baidu.live.d.xc().putString("live_pk_rank_task_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ifQ));
    }

    private o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static o ihm = new o();
    }
}
