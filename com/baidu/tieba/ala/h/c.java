package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.aj;
import com.baidu.live.data.bs;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements com.baidu.live.q.d {
    private static final String hDF = com.baidu.live.ab.b.PU();
    private static final String hDG = com.baidu.live.ab.b.PV();
    private static final String hDH = com.baidu.live.ab.b.PW();
    private boolean hDI;
    private HttpMessageListener hDJ;
    private d hDK;
    private String hDL;

    public static c ciy() {
        return a.hDO;
    }

    public String ciz() {
        return this.hDL;
    }

    @Override // com.baidu.live.q.d
    public void Oo() {
        final aj ajVar = com.baidu.live.z.a.Pq().bmJ;
        if (ajVar == null || ajVar.aMw == null || TextUtils.isEmpty(ajVar.aMw.downloadUrl)) {
            bRL();
        } else if (!this.hDI) {
            this.hDL = "";
            this.hDI = true;
            new BdAsyncTask<bs, Void, bs>() { // from class: com.baidu.tieba.ala.h.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public bs doInBackground(bs... bsVarArr) {
                    bs Iw;
                    if (bsVarArr == null || bsVarArr.length == 0) {
                        return null;
                    }
                    bs bsVar = bsVarArr[0];
                    String string = com.baidu.live.d.AZ().getString("live_pk_rank_start_anim", "");
                    if (TextUtils.isEmpty(string) || (Iw = b.Iw(string)) == null || !bsVar.downloadUrl.equals(Iw.downloadUrl) || !bsVar.aPt.equals(Iw.aPt) || TextUtils.isEmpty(Iw.videoMd5) || !Iw.videoMd5.equals(c.this.ciA())) {
                        c.this.ciB();
                        return null;
                    }
                    return Iw;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(bs bsVar) {
                    super.onPostExecute(bsVar);
                    if (bsVar == null) {
                        c.this.b(ajVar.aMw);
                        return;
                    }
                    c.this.hDL = bsVar.videoPath;
                }
            }.execute(ajVar.aMw);
        }
    }

    @Override // com.baidu.live.q.d
    public void release() {
        this.hDI = false;
        this.hDL = "";
        MessageManager.getInstance().unRegisterListener(this.hDJ);
        this.hDJ = null;
        if (this.hDK != null) {
            this.hDK.release();
        }
        com.baidu.live.f.b.dT(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cx(List<bs> list) {
        if (list != null && !list.isEmpty()) {
            bs bsVar = list.get(0);
            this.hDL = bsVar.videoPath;
            com.baidu.live.d.AZ().putString("live_pk_rank_start_anim", b.a(bsVar));
        }
    }

    private void bRL() {
        if (this.hDJ == null) {
            this.hDJ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.Oo();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hDJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ciA() {
        File[] listFiles = new File(hDH).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        for (File file : listFiles) {
            if (!file.isDirectory()) {
                return com.baidu.live.f.a.getFileMd5(file);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bs bsVar) {
        if (bsVar != null && !TextUtils.isEmpty(bsVar.downloadUrl)) {
            this.hDK = new d();
            this.hDK.z(bsVar.downloadUrl, bsVar.aPt, hDG, hDH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciB() {
        this.hDL = "";
        com.baidu.live.d.AZ().putString("live_pk_rank_start_anim", "");
        com.baidu.live.f.a.cleanDir(new File(hDF));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static c hDO = new c();
    }
}
