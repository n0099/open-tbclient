package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.ag;
import com.baidu.live.data.bo;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.utils.s;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements com.baidu.live.p.d {
    private static final String hrL = s.Rb();
    private static final String hrM = s.Rc();
    private static final String hrN = s.Rd();
    private boolean hrO;
    private HttpMessageListener hrP;
    private d hrQ;
    private String hrR;

    public static c cfw() {
        return a.hrU;
    }

    public String cfx() {
        return this.hrR;
    }

    @Override // com.baidu.live.p.d
    public void NQ() {
        final ag agVar = com.baidu.live.x.a.OS().blo;
        if (agVar == null || agVar.aLS == null || TextUtils.isEmpty(agVar.aLS.downloadUrl)) {
            cfy();
        } else if (!this.hrO) {
            this.hrR = "";
            this.hrO = true;
            new BdAsyncTask<bo, Void, bo>() { // from class: com.baidu.tieba.ala.h.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public bo doInBackground(bo... boVarArr) {
                    bo HX;
                    if (boVarArr == null || boVarArr.length == 0) {
                        return null;
                    }
                    bo boVar = boVarArr[0];
                    String string = com.baidu.live.c.AZ().getString("live_pk_rank_start_anim", "");
                    if (TextUtils.isEmpty(string) || (HX = b.HX(string)) == null || !boVar.downloadUrl.equals(HX.downloadUrl) || !boVar.aOO.equals(HX.aOO) || TextUtils.isEmpty(HX.videoMd5) || !HX.videoMd5.equals(c.this.cfz())) {
                        c.this.cfA();
                        return null;
                    }
                    return HX;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(bo boVar) {
                    super.onPostExecute(boVar);
                    if (boVar == null) {
                        c.this.b(agVar.aLS);
                        return;
                    }
                    c.this.hrR = boVar.videoPath;
                }
            }.execute(agVar.aLS);
        }
    }

    @Override // com.baidu.live.p.d
    public void release() {
        this.hrO = false;
        this.hrR = "";
        MessageManager.getInstance().unRegisterListener(this.hrP);
        this.hrP = null;
        if (this.hrQ != null) {
            this.hrQ.release();
        }
        com.baidu.live.f.b.dT(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void co(List<bo> list) {
        if (list != null && !list.isEmpty()) {
            bo boVar = list.get(0);
            this.hrR = boVar.videoPath;
            com.baidu.live.c.AZ().putString("live_pk_rank_start_anim", b.a(boVar));
        }
    }

    private void cfy() {
        if (this.hrP == null) {
            this.hrP = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.NQ();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hrP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cfz() {
        File[] listFiles = new File(hrN).listFiles();
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
    public void b(bo boVar) {
        if (boVar != null && !TextUtils.isEmpty(boVar.downloadUrl)) {
            this.hrQ = new d();
            this.hrQ.y(boVar.downloadUrl, boVar.aOO, hrM, hrN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfA() {
        this.hrR = "";
        com.baidu.live.c.AZ().putString("live_pk_rank_start_anim", "");
        com.baidu.live.f.a.cleanDir(new File(hrL));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static c hrU = new c();
    }
}
