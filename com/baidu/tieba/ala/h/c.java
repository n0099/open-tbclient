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
    private static final String hcI = s.PW();
    private static final String hcJ = s.PX();
    private static final String hcK = s.PY();
    private boolean hcL;
    private HttpMessageListener hcM;
    private d hcN;
    private String hcO;

    public static c cca() {
        return a.hcR;
    }

    public String ccb() {
        return this.hcO;
    }

    @Override // com.baidu.live.p.d
    public void ML() {
        final ag agVar = com.baidu.live.x.a.NN().bhy;
        if (agVar == null || agVar.aIO == null || TextUtils.isEmpty(agVar.aIO.downloadUrl)) {
            ccc();
        } else if (!this.hcL) {
            this.hcO = "";
            this.hcL = true;
            new BdAsyncTask<bo, Void, bo>() { // from class: com.baidu.tieba.ala.h.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public bo doInBackground(bo... boVarArr) {
                    bo Hj;
                    if (boVarArr == null || boVarArr.length == 0) {
                        return null;
                    }
                    bo boVar = boVarArr[0];
                    String string = com.baidu.live.c.AR().getString("live_pk_rank_start_anim", "");
                    if (TextUtils.isEmpty(string) || (Hj = b.Hj(string)) == null || !boVar.downloadUrl.equals(Hj.downloadUrl) || !boVar.aLJ.equals(Hj.aLJ) || TextUtils.isEmpty(Hj.videoMd5) || !Hj.videoMd5.equals(c.this.ccd())) {
                        c.this.cce();
                        return null;
                    }
                    return Hj;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(bo boVar) {
                    super.onPostExecute(boVar);
                    if (boVar == null) {
                        c.this.b(agVar.aIO);
                        return;
                    }
                    c.this.hcO = boVar.videoPath;
                }
            }.execute(agVar.aIO);
        }
    }

    @Override // com.baidu.live.p.d
    public void release() {
        this.hcL = false;
        this.hcO = "";
        MessageManager.getInstance().unRegisterListener(this.hcM);
        this.hcM = null;
        if (this.hcN != null) {
            this.hcN.release();
        }
        com.baidu.live.f.b.dO(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cl(List<bo> list) {
        if (list != null && !list.isEmpty()) {
            bo boVar = list.get(0);
            this.hcO = boVar.videoPath;
            com.baidu.live.c.AR().putString("live_pk_rank_start_anim", b.a(boVar));
        }
    }

    private void ccc() {
        if (this.hcM == null) {
            this.hcM = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.ML();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hcM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ccd() {
        File[] listFiles = new File(hcK).listFiles();
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
            this.hcN = new d();
            this.hcN.x(boVar.downloadUrl, boVar.aLJ, hcJ, hcK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cce() {
        this.hcO = "";
        com.baidu.live.c.AR().putString("live_pk_rank_start_anim", "");
        com.baidu.live.f.a.cleanDir(new File(hcI));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static c hcR = new c();
    }
}
