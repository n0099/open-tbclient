package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.ar;
import com.baidu.live.data.cb;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import java.io.File;
import java.util.List;
/* loaded from: classes10.dex */
public class g implements com.baidu.live.t.b {
    private boolean ihC;
    private HttpMessageListener ihD;
    private String ihF;
    private h iiG;
    private static final String ihz = com.baidu.live.storage.b.QU();
    private static final String ihA = com.baidu.live.storage.b.QZ();
    private static final String ihB = com.baidu.live.storage.b.Rd();

    public static g cpb() {
        return a.iiI;
    }

    public String coK() {
        return this.ihF;
    }

    @Override // com.baidu.live.t.b
    public void Pm() {
        final ar arVar = com.baidu.live.ae.a.Qm().bwx;
        if (arVar == null || arVar.aOP == null || TextUtils.isEmpty(arVar.aOP.downloadUrl)) {
            bWS();
        } else if (!this.ihC) {
            this.ihF = "";
            this.ihC = true;
            new BdAsyncTask<cb, Void, cb>() { // from class: com.baidu.tieba.ala.h.g.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public cb doInBackground(cb... cbVarArr) {
                    cb IF;
                    if (cbVarArr == null || cbVarArr.length == 0) {
                        return null;
                    }
                    cb cbVar = cbVarArr[0];
                    String string = com.baidu.live.d.xf().getString("live_pk_rank_kill_anim", "");
                    if (TextUtils.isEmpty(string) || (IF = f.IF(string)) == null || !cbVar.downloadUrl.equals(IF.downloadUrl) || !cbVar.aSj.equals(IF.aSj) || TextUtils.isEmpty(IF.videoMd5) || !IF.videoMd5.equals(g.this.coL())) {
                        g.this.coM();
                        return null;
                    }
                    return IF;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: b */
                public void onPostExecute(cb cbVar) {
                    super.onPostExecute(cbVar);
                    if (cbVar == null) {
                        g.this.a(arVar.aOP);
                        return;
                    }
                    g.this.ihF = cbVar.videoPath;
                }
            }.execute(arVar.aOP);
        }
    }

    @Override // com.baidu.live.t.b
    public void release() {
        this.ihC = false;
        this.ihF = "";
        MessageManager.getInstance().unRegisterListener(this.ihD);
        this.ihD = null;
        if (this.iiG != null) {
            this.iiG.release();
        }
        com.baidu.live.h.b.cF(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cb> list) {
        if (list != null && !list.isEmpty()) {
            cb cbVar = list.get(0);
            this.ihF = cbVar.videoPath;
            com.baidu.live.d.xf().putString("live_pk_rank_kill_anim", f.c(cbVar));
        }
    }

    private void bWS() {
        if (this.ihD == null) {
            this.ihD = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.g.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        g.this.Pm();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ihD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String coL() {
        File[] listFiles = new File(ihB).listFiles();
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
    public void a(cb cbVar) {
        if (cbVar != null && !TextUtils.isEmpty(cbVar.downloadUrl)) {
            this.iiG = new h();
            this.iiG.y(cbVar.downloadUrl, cbVar.aSj, ihA, ihB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coM() {
        this.ihF = "";
        com.baidu.live.d.xf().putString("live_pk_rank_kill_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ihz));
    }

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static g iiI = new g();
    }
}
