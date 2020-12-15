package com.baidu.tieba.ala.poke.startanim;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.al;
import com.baidu.live.data.bw;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements com.baidu.live.v.c {
    private static final String hTp = com.baidu.live.ag.b.Sh();
    private static final String hTq = com.baidu.live.ag.b.Sj();
    private static final String hTr = com.baidu.live.ag.b.Sl();
    private boolean hTs;
    private HttpMessageListener hTt;
    private d hTu;
    private String hTv;

    public static c cow() {
        return a.hTy;
    }

    public String cox() {
        return this.hTv;
    }

    @Override // com.baidu.live.v.c
    public void Qy() {
        final al alVar = com.baidu.live.ae.a.RB().brA;
        if (alVar == null || alVar.aOH == null || TextUtils.isEmpty(alVar.aOH.downloadUrl)) {
            bXn();
        } else if (!this.hTs) {
            this.hTv = "";
            this.hTs = true;
            new BdAsyncTask<bw, Void, bw>() { // from class: com.baidu.tieba.ala.poke.startanim.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public bw doInBackground(bw... bwVarArr) {
                    bw Jd;
                    if (bwVarArr == null || bwVarArr.length == 0) {
                        return null;
                    }
                    bw bwVar = bwVarArr[0];
                    String string = com.baidu.live.d.BM().getString("live_poke_start_anim", "");
                    if (TextUtils.isEmpty(string) || (Jd = b.Jd(string)) == null || !bwVar.downloadUrl.equals(Jd.downloadUrl) || !bwVar.aRG.equals(Jd.aRG) || TextUtils.isEmpty(Jd.videoMd5) || !Jd.videoMd5.equals(c.this.coy())) {
                        c.this.coz();
                        return null;
                    }
                    return Jd;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(bw bwVar) {
                    super.onPostExecute(bwVar);
                    if (bwVar == null) {
                        c.this.b(alVar.aOH);
                        return;
                    }
                    c.this.hTv = bwVar.videoPath;
                }
            }.execute(alVar.aOH);
        }
    }

    @Override // com.baidu.live.v.c
    public void release() {
        this.hTs = false;
        this.hTv = "";
        MessageManager.getInstance().unRegisterListener(this.hTt);
        this.hTt = null;
        if (this.hTu != null) {
            this.hTu.release();
        }
        com.baidu.live.h.b.ei(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cJ(List<bw> list) {
        if (list != null && !list.isEmpty()) {
            bw bwVar = list.get(0);
            this.hTv = bwVar.videoPath;
            com.baidu.live.d.BM().putString("live_poke_start_anim", b.a(bwVar));
        }
    }

    private void bXn() {
        if (this.hTt == null) {
            this.hTt = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.poke.startanim.c.2
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
    public void b(bw bwVar) {
        if (bwVar != null && !TextUtils.isEmpty(bwVar.downloadUrl)) {
            this.hTu = new d();
            this.hTu.z(bwVar.downloadUrl, bwVar.aRG, hTq, hTr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coz() {
        this.hTv = "";
        com.baidu.live.d.BM().putString("live_poke_start_anim", "");
        com.baidu.live.h.a.cleanDir(new File(hTp));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static c hTy = new c();
    }
}
