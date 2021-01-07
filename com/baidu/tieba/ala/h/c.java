package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.an;
import com.baidu.live.data.bw;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import java.io.File;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements com.baidu.live.u.d {
    private static final String ifP = com.baidu.live.ah.b.Tk();
    private static final String ifQ = com.baidu.live.ah.b.Tm();
    private static final String ifR = com.baidu.live.ah.b.To();
    private boolean ifS;
    private HttpMessageListener ifT;
    private String ifV;
    private d igO;

    public static c crG() {
        return a.igQ;
    }

    public String crr() {
        return this.ifV;
    }

    @Override // com.baidu.live.u.d
    public void RC() {
        final an anVar = com.baidu.live.af.a.SE().bwi;
        if (anVar == null || anVar.aPn == null || TextUtils.isEmpty(anVar.aPn.downloadUrl)) {
            bZT();
        } else if (!this.ifS) {
            this.ifV = "";
            this.ifS = true;
            new BdAsyncTask<bw, Void, bw>() { // from class: com.baidu.tieba.ala.h.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public bw doInBackground(bw... bwVarArr) {
                    bw Jc;
                    if (bwVarArr == null || bwVarArr.length == 0) {
                        return null;
                    }
                    bw bwVar = bwVarArr[0];
                    String string = com.baidu.live.d.Ba().getString("live_pk_rank_start_anim", "");
                    if (TextUtils.isEmpty(string) || (Jc = b.Jc(string)) == null || !bwVar.downloadUrl.equals(Jc.downloadUrl) || !bwVar.aSv.equals(Jc.aSv) || TextUtils.isEmpty(Jc.videoMd5) || !Jc.videoMd5.equals(c.this.crs())) {
                        c.this.crt();
                        return null;
                    }
                    return Jc;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(bw bwVar) {
                    super.onPostExecute(bwVar);
                    if (bwVar == null) {
                        c.this.b(anVar.aPn);
                        return;
                    }
                    c.this.ifV = bwVar.videoPath;
                }
            }.execute(anVar.aPn);
        }
    }

    @Override // com.baidu.live.u.d
    public void release() {
        this.ifS = false;
        this.ifV = "";
        MessageManager.getInstance().unRegisterListener(this.ifT);
        this.ifT = null;
        if (this.igO != null) {
            this.igO.release();
        }
        com.baidu.live.i.b.ef(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cQ(List<bw> list) {
        if (list != null && !list.isEmpty()) {
            bw bwVar = list.get(0);
            this.ifV = bwVar.videoPath;
            com.baidu.live.d.Ba().putString("live_pk_rank_start_anim", b.a(bwVar));
        }
    }

    private void bZT() {
        if (this.ifT == null) {
            this.ifT = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.RC();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ifT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String crs() {
        File[] listFiles = new File(ifR).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        for (File file : listFiles) {
            if (!file.isDirectory()) {
                return com.baidu.live.i.a.getFileMd5(file);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bw bwVar) {
        if (bwVar != null && !TextUtils.isEmpty(bwVar.downloadUrl)) {
            this.igO = new d();
            this.igO.y(bwVar.downloadUrl, bwVar.aSv, ifQ, ifR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crt() {
        this.ifV = "";
        com.baidu.live.d.Ba().putString("live_pk_rank_start_anim", "");
        com.baidu.live.i.a.cleanDir(new File(ifP));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static c igQ = new c();
    }
}
