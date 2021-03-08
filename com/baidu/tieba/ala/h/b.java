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
public class b implements com.baidu.live.t.b {
    private boolean ihC;
    private HttpMessageListener ihD;
    private String ihF;
    private c iix;
    private static final String ihz = com.baidu.live.storage.b.QV();
    private static final String ihA = com.baidu.live.storage.b.Ra();
    private static final String ihB = com.baidu.live.storage.b.Re();

    public static b coZ() {
        return a.iiz;
    }

    public String coK() {
        return this.ihF;
    }

    @Override // com.baidu.live.t.b
    public void Pm() {
        final ar arVar = com.baidu.live.ae.a.Qm().bwx;
        if (arVar == null || arVar.aOQ == null || TextUtils.isEmpty(arVar.aOQ.downloadUrl)) {
            bWS();
        } else if (!this.ihC) {
            this.ihF = "";
            this.ihC = true;
            new BdAsyncTask<cb, Void, cb>() { // from class: com.baidu.tieba.ala.h.b.1
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
                    String string = com.baidu.live.d.xf().getString("live_pk_rank_anti_kill_anim", "");
                    if (TextUtils.isEmpty(string) || (IF = f.IF(string)) == null || !cbVar.downloadUrl.equals(IF.downloadUrl) || !cbVar.aSj.equals(IF.aSj) || TextUtils.isEmpty(IF.videoMd5) || !IF.videoMd5.equals(b.this.coL())) {
                        b.this.coM();
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
                        b.this.a(arVar.aOQ);
                        return;
                    }
                    b.this.ihF = cbVar.videoPath;
                }
            }.execute(arVar.aOQ);
        }
    }

    @Override // com.baidu.live.t.b
    public void release() {
        this.ihC = false;
        this.ihF = "";
        MessageManager.getInstance().unRegisterListener(this.ihD);
        this.ihD = null;
        if (this.iix != null) {
            this.iix.release();
        }
        com.baidu.live.h.b.cF(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cb> list) {
        if (list != null && !list.isEmpty()) {
            cb cbVar = list.get(0);
            this.ihF = cbVar.videoPath;
            com.baidu.live.d.xf().putString("live_pk_rank_anti_kill_anim", f.c(cbVar));
        }
    }

    private void bWS() {
        if (this.ihD == null) {
            this.ihD = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        b.this.Pm();
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
            this.iix = new c();
            this.iix.y(cbVar.downloadUrl, cbVar.aSj, ihA, ihB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coM() {
        this.ihF = "";
        com.baidu.live.d.xf().putString("live_pk_rank_anti_kill_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ihz));
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static b iiz = new b();
    }
}
