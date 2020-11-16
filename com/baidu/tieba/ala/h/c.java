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
    private static final String hJj = com.baidu.live.ac.b.PL();
    private static final String hJk = com.baidu.live.ac.b.PM();
    private static final String hJl = com.baidu.live.ac.b.PN();
    private boolean hJm;
    private HttpMessageListener hJn;
    private d hJo;
    private String hJp;

    public static c ckt() {
        return a.hJs;
    }

    public String cku() {
        return this.hJp;
    }

    @Override // com.baidu.live.r.d
    public void Of() {
        final ak akVar = com.baidu.live.aa.a.Ph().bms;
        if (akVar == null || akVar.aLL == null || TextUtils.isEmpty(akVar.aLL.downloadUrl)) {
            bTD();
        } else if (!this.hJm) {
            this.hJp = "";
            this.hJm = true;
            new BdAsyncTask<bt, Void, bt>() { // from class: com.baidu.tieba.ala.h.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public bt doInBackground(bt... btVarArr) {
                    bt Io;
                    if (btVarArr == null || btVarArr.length == 0) {
                        return null;
                    }
                    bt btVar = btVarArr[0];
                    String string = com.baidu.live.d.Aq().getString("live_pk_rank_start_anim", "");
                    if (TextUtils.isEmpty(string) || (Io = b.Io(string)) == null || !btVar.downloadUrl.equals(Io.downloadUrl) || !btVar.aOF.equals(Io.aOF) || TextUtils.isEmpty(Io.videoMd5) || !Io.videoMd5.equals(c.this.ckv())) {
                        c.this.ckw();
                        return null;
                    }
                    return Io;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(bt btVar) {
                    super.onPostExecute(btVar);
                    if (btVar == null) {
                        c.this.b(akVar.aLL);
                        return;
                    }
                    c.this.hJp = btVar.videoPath;
                }
            }.execute(akVar.aLL);
        }
    }

    @Override // com.baidu.live.r.d
    public void release() {
        this.hJm = false;
        this.hJp = "";
        MessageManager.getInstance().unRegisterListener(this.hJn);
        this.hJn = null;
        if (this.hJo != null) {
            this.hJo.release();
        }
        com.baidu.live.f.b.dP(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cF(List<bt> list) {
        if (list != null && !list.isEmpty()) {
            bt btVar = list.get(0);
            this.hJp = btVar.videoPath;
            com.baidu.live.d.Aq().putString("live_pk_rank_start_anim", b.a(btVar));
        }
    }

    private void bTD() {
        if (this.hJn == null) {
            this.hJn = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.h.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.Of();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hJn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ckv() {
        File[] listFiles = new File(hJl).listFiles();
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
            this.hJo = new d();
            this.hJo.z(btVar.downloadUrl, btVar.aOF, hJk, hJl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckw() {
        this.hJp = "";
        com.baidu.live.d.Aq().putString("live_pk_rank_start_anim", "");
        com.baidu.live.f.a.cleanDir(new File(hJj));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static c hJs = new c();
    }
}
