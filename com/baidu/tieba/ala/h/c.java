package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.ak;
import com.baidu.live.data.bt;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements com.baidu.live.r.d {
    private static final String hJC = com.baidu.live.ac.b.Qu();
    private static final String hJD = com.baidu.live.ac.b.Qv();
    private static final String hJE = com.baidu.live.ac.b.Qw();
    private boolean hJF;
    private HttpMessageListener hJG;
    private d hJH;
    private String hJI;

    public static c cla() {
        return a.hJL;
    }

    public String clb() {
        return this.hJI;
    }

    @Override // com.baidu.live.r.d
    public void OO() {
        final ak akVar = com.baidu.live.aa.a.PQ().bod;
        if (akVar == null || akVar.aNw == null || TextUtils.isEmpty(akVar.aNw.downloadUrl)) {
            bUk();
        } else if (!this.hJF) {
            this.hJI = "";
            this.hJF = true;
            new BdAsyncTask<bt, Void, bt>() { // from class: com.baidu.tieba.ala.h.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public bt doInBackground(bt... btVarArr) {
                    bt IN;
                    if (btVarArr == null || btVarArr.length == 0) {
                        return null;
                    }
                    bt btVar = btVarArr[0];
                    String string = com.baidu.live.d.AZ().getString("live_pk_rank_start_anim", "");
                    if (TextUtils.isEmpty(string) || (IN = b.IN(string)) == null || !btVar.downloadUrl.equals(IN.downloadUrl) || !btVar.aQq.equals(IN.aQq) || TextUtils.isEmpty(IN.videoMd5) || !IN.videoMd5.equals(c.this.clc())) {
                        c.this.cld();
                        return null;
                    }
                    return IN;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(bt btVar) {
                    super.onPostExecute(btVar);
                    if (btVar == null) {
                        c.this.b(akVar.aNw);
                        return;
                    }
                    c.this.hJI = btVar.videoPath;
                }
            }.execute(akVar.aNw);
        }
    }

    @Override // com.baidu.live.r.d
    public void release() {
        this.hJF = false;
        this.hJI = "";
        MessageManager.getInstance().unRegisterListener(this.hJG);
        this.hJG = null;
        if (this.hJH != null) {
            this.hJH.release();
        }
        com.baidu.live.f.b.dT(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cF(List<bt> list) {
        if (list != null && !list.isEmpty()) {
            bt btVar = list.get(0);
            this.hJI = btVar.videoPath;
            com.baidu.live.d.AZ().putString("live_pk_rank_start_anim", b.a(btVar));
        }
    }

    private void bUk() {
        if (this.hJG == null) {
            this.hJG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.OO();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hJG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String clc() {
        File[] listFiles = new File(hJE).listFiles();
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
    public void b(bt btVar) {
        if (btVar != null && !TextUtils.isEmpty(btVar.downloadUrl)) {
            this.hJH = new d();
            this.hJH.z(btVar.downloadUrl, btVar.aQq, hJD, hJE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cld() {
        this.hJI = "";
        com.baidu.live.d.AZ().putString("live_pk_rank_start_anim", "");
        com.baidu.live.f.a.cleanDir(new File(hJC));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static c hJL = new c();
    }
}
