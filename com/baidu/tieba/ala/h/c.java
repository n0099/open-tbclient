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
/* loaded from: classes10.dex */
public class c implements com.baidu.live.u.d {
    private static final String ibe = com.baidu.live.ah.b.Pp();
    private static final String ibf = com.baidu.live.ah.b.Pr();
    private static final String ibg = com.baidu.live.ah.b.Pt();
    private boolean ibh;
    private HttpMessageListener ibi;
    private String ibk;
    private d icd;

    public static c cnO() {
        return a.icf;
    }

    public String cnz() {
        return this.ibk;
    }

    @Override // com.baidu.live.u.d
    public void NH() {
        final an anVar = com.baidu.live.af.a.OJ().bru;
        if (anVar == null || anVar.aKA == null || TextUtils.isEmpty(anVar.aKA.downloadUrl)) {
            bWb();
        } else if (!this.ibh) {
            this.ibk = "";
            this.ibh = true;
            new BdAsyncTask<bw, Void, bw>() { // from class: com.baidu.tieba.ala.h.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public bw doInBackground(bw... bwVarArr) {
                    bw HR;
                    if (bwVarArr == null || bwVarArr.length == 0) {
                        return null;
                    }
                    bw bwVar = bwVarArr[0];
                    String string = com.baidu.live.d.xf().getString("live_pk_rank_start_anim", "");
                    if (TextUtils.isEmpty(string) || (HR = b.HR(string)) == null || !bwVar.downloadUrl.equals(HR.downloadUrl) || !bwVar.aNI.equals(HR.aNI) || TextUtils.isEmpty(HR.videoMd5) || !HR.videoMd5.equals(c.this.cnA())) {
                        c.this.cnB();
                        return null;
                    }
                    return HR;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(bw bwVar) {
                    super.onPostExecute(bwVar);
                    if (bwVar == null) {
                        c.this.b(anVar.aKA);
                        return;
                    }
                    c.this.ibk = bwVar.videoPath;
                }
            }.execute(anVar.aKA);
        }
    }

    @Override // com.baidu.live.u.d
    public void release() {
        this.ibh = false;
        this.ibk = "";
        MessageManager.getInstance().unRegisterListener(this.ibi);
        this.ibi = null;
        if (this.icd != null) {
            this.icd.release();
        }
        com.baidu.live.i.b.cz(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cQ(List<bw> list) {
        if (list != null && !list.isEmpty()) {
            bw bwVar = list.get(0);
            this.ibk = bwVar.videoPath;
            com.baidu.live.d.xf().putString("live_pk_rank_start_anim", b.a(bwVar));
        }
    }

    private void bWb() {
        if (this.ibi == null) {
            this.ibi = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.NH();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ibi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cnA() {
        File[] listFiles = new File(ibg).listFiles();
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
            this.icd = new d();
            this.icd.y(bwVar.downloadUrl, bwVar.aNI, ibf, ibg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnB() {
        this.ibk = "";
        com.baidu.live.d.xf().putString("live_pk_rank_start_anim", "");
        com.baidu.live.i.a.cleanDir(new File(ibe));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static c icf = new c();
    }
}
