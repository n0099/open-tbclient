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
    private static final String ifC = com.baidu.live.storage.b.QT();
    private static final String ifD = com.baidu.live.storage.b.QY();
    private static final String ifE = com.baidu.live.storage.b.Rc();
    private boolean ifF;
    private HttpMessageListener ifG;
    private String ifI;
    private p igW;

    public static o coT() {
        return a.igY;
    }

    public String cox() {
        return this.ifI;
    }

    @Override // com.baidu.live.t.f
    public void Pj() {
        final ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar == null || arVar.aNo == null || TextUtils.isEmpty(arVar.aNo.downloadUrl)) {
            bWF();
        } else if (!this.ifF) {
            this.ifI = "";
            this.ifF = true;
            new BdAsyncTask<cd, Void, cd>() { // from class: com.baidu.tieba.ala.h.o.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public cd doInBackground(cd... cdVarArr) {
                    cd Ix;
                    if (cdVarArr == null || cdVarArr.length == 0) {
                        return null;
                    }
                    cd cdVar = cdVarArr[0];
                    String string = com.baidu.live.d.xc().getString("live_pk_rank_task_anim", "");
                    if (TextUtils.isEmpty(string) || (Ix = n.Ix(string)) == null || !cdVar.downloadUrl.equals(Ix.downloadUrl) || !cdVar.aQJ.equals(Ix.aQJ) || TextUtils.isEmpty(Ix.videoMd5) || !Ix.videoMd5.equals(o.this.coy())) {
                        o.this.coz();
                        return null;
                    }
                    return Ix;
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
                    o.this.ifI = cdVar.videoPath;
                }
            }.execute(arVar.aNo);
        }
    }

    @Override // com.baidu.live.t.f
    public void release() {
        this.ifF = false;
        this.ifI = "";
        MessageManager.getInstance().unRegisterListener(this.ifG);
        this.ifG = null;
        if (this.igW != null) {
            this.igW.release();
        }
        com.baidu.live.h.b.cE(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cd> list) {
        if (list != null && !list.isEmpty()) {
            cd cdVar = list.get(0);
            this.ifI = cdVar.videoPath;
            com.baidu.live.d.xc().putString("live_pk_rank_task_anim", n.a(cdVar));
        }
    }

    private void bWF() {
        if (this.ifG == null) {
            this.ifG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.o.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        o.this.Pj();
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
    public void b(cd cdVar) {
        if (cdVar != null && !TextUtils.isEmpty(cdVar.downloadUrl)) {
            this.igW = new p();
            this.igW.y(cdVar.downloadUrl, cdVar.aQJ, ifD, ifE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coz() {
        this.ifI = "";
        com.baidu.live.d.xc().putString("live_pk_rank_task_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ifC));
    }

    private o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static o igY = new o();
    }
}
