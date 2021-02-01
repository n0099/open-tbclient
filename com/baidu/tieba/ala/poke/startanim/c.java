package com.baidu.tieba.ala.poke.startanim;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.ar;
import com.baidu.live.data.cf;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import java.io.File;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements com.baidu.live.v.c {
    private static final String ifC = com.baidu.live.storage.b.QU();
    private static final String ifD = com.baidu.live.storage.b.QZ();
    private static final String ifE = com.baidu.live.storage.b.Re();
    private boolean ifF;
    private HttpMessageListener ifG;
    private d ifH;
    private String ifI;

    public static c cow() {
        return a.ifL;
    }

    public String cox() {
        return this.ifI;
    }

    @Override // com.baidu.live.v.c
    public void Pj() {
        final ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar == null || arVar.aNr == null || TextUtils.isEmpty(arVar.aNr.downloadUrl)) {
            bWF();
        } else if (!this.ifF) {
            this.ifI = "";
            this.ifF = true;
            new BdAsyncTask<cf, Void, cf>() { // from class: com.baidu.tieba.ala.poke.startanim.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public cf doInBackground(cf... cfVarArr) {
                    cf It;
                    if (cfVarArr == null || cfVarArr.length == 0) {
                        return null;
                    }
                    cf cfVar = cfVarArr[0];
                    String string = com.baidu.live.d.xc().getString("live_poke_start_anim", "");
                    if (TextUtils.isEmpty(string) || (It = b.It(string)) == null || !cfVar.downloadUrl.equals(It.downloadUrl) || !cfVar.aQJ.equals(It.aQJ) || TextUtils.isEmpty(It.videoMd5) || !It.videoMd5.equals(c.this.coy())) {
                        c.this.coz();
                        return null;
                    }
                    return It;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(cf cfVar) {
                    super.onPostExecute(cfVar);
                    if (cfVar == null) {
                        c.this.b(arVar.aNr);
                        return;
                    }
                    c.this.ifI = cfVar.videoPath;
                }
            }.execute(arVar.aNr);
        }
    }

    @Override // com.baidu.live.v.c
    public void release() {
        this.ifF = false;
        this.ifI = "";
        MessageManager.getInstance().unRegisterListener(this.ifG);
        this.ifG = null;
        if (this.ifH != null) {
            this.ifH.release();
        }
        com.baidu.live.h.b.cE(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cf> list) {
        if (list != null && !list.isEmpty()) {
            cf cfVar = list.get(0);
            this.ifI = cfVar.videoPath;
            com.baidu.live.d.xc().putString("live_poke_start_anim", b.a(cfVar));
        }
    }

    private void bWF() {
        if (this.ifG == null) {
            this.ifG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.poke.startanim.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.Pj();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ifG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String coy() {
        File[] listFiles = new File(ifE).listFiles();
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
    public void b(cf cfVar) {
        if (cfVar != null && !TextUtils.isEmpty(cfVar.downloadUrl)) {
            this.ifH = new d();
            this.ifH.y(cfVar.downloadUrl, cfVar.aQJ, ifD, ifE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coz() {
        this.ifI = "";
        com.baidu.live.d.xc().putString("live_poke_start_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ifC));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static c ifL = new c();
    }
}
