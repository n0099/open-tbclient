package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.al;
import com.baidu.live.data.bu;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements com.baidu.live.t.d {
    private static final String hTp = com.baidu.live.ag.b.Sg();
    private static final String hTq = com.baidu.live.ag.b.Si();
    private static final String hTr = com.baidu.live.ag.b.Sk();
    private boolean hTs;
    private HttpMessageListener hTt;
    private String hTv;
    private d hUo;

    public static c coM() {
        return a.hUq;
    }

    public String cox() {
        return this.hTv;
    }

    @Override // com.baidu.live.t.d
    public void Qy() {
        final al alVar = com.baidu.live.ae.a.RB().brA;
        if (alVar == null || alVar.aOG == null || TextUtils.isEmpty(alVar.aOG.downloadUrl)) {
            bXn();
        } else if (!this.hTs) {
            this.hTv = "";
            this.hTs = true;
            new BdAsyncTask<bu, Void, bu>() { // from class: com.baidu.tieba.ala.h.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public bu doInBackground(bu... buVarArr) {
                    bu Jf;
                    if (buVarArr == null || buVarArr.length == 0) {
                        return null;
                    }
                    bu buVar = buVarArr[0];
                    String string = com.baidu.live.d.BM().getString("live_pk_rank_start_anim", "");
                    if (TextUtils.isEmpty(string) || (Jf = b.Jf(string)) == null || !buVar.downloadUrl.equals(Jf.downloadUrl) || !buVar.aRG.equals(Jf.aRG) || TextUtils.isEmpty(Jf.videoMd5) || !Jf.videoMd5.equals(c.this.coy())) {
                        c.this.coz();
                        return null;
                    }
                    return Jf;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(bu buVar) {
                    super.onPostExecute(buVar);
                    if (buVar == null) {
                        c.this.b(alVar.aOG);
                        return;
                    }
                    c.this.hTv = buVar.videoPath;
                }
            }.execute(alVar.aOG);
        }
    }

    @Override // com.baidu.live.t.d
    public void release() {
        this.hTs = false;
        this.hTv = "";
        MessageManager.getInstance().unRegisterListener(this.hTt);
        this.hTt = null;
        if (this.hUo != null) {
            this.hUo.release();
        }
        com.baidu.live.h.b.ei(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cJ(List<bu> list) {
        if (list != null && !list.isEmpty()) {
            bu buVar = list.get(0);
            this.hTv = buVar.videoPath;
            com.baidu.live.d.BM().putString("live_pk_rank_start_anim", b.a(buVar));
        }
    }

    private void bXn() {
        if (this.hTt == null) {
            this.hTt = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.Qy();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hTt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String coy() {
        File[] listFiles = new File(hTr).listFiles();
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
    public void b(bu buVar) {
        if (buVar != null && !TextUtils.isEmpty(buVar.downloadUrl)) {
            this.hUo = new d();
            this.hUo.z(buVar.downloadUrl, buVar.aRG, hTq, hTr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coz() {
        this.hTv = "";
        com.baidu.live.d.BM().putString("live_pk_rank_start_anim", "");
        com.baidu.live.h.a.cleanDir(new File(hTp));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static c hUq = new c();
    }
}
