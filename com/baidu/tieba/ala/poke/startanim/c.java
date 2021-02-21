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
    private static final String ifQ = com.baidu.live.storage.b.QU();
    private static final String ifR = com.baidu.live.storage.b.QZ();
    private static final String ifS = com.baidu.live.storage.b.Re();
    private boolean ifT;
    private HttpMessageListener ifU;
    private d ifV;
    private String ifW;

    public static c coD() {
        return a.ifZ;
    }

    public String coE() {
        return this.ifW;
    }

    @Override // com.baidu.live.v.c
    public void Pj() {
        final ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar == null || arVar.aNr == null || TextUtils.isEmpty(arVar.aNr.downloadUrl)) {
            bWM();
        } else if (!this.ifT) {
            this.ifW = "";
            this.ifT = true;
            new BdAsyncTask<cf, Void, cf>() { // from class: com.baidu.tieba.ala.poke.startanim.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public cf doInBackground(cf... cfVarArr) {
                    cf Iu;
                    if (cfVarArr == null || cfVarArr.length == 0) {
                        return null;
                    }
                    cf cfVar = cfVarArr[0];
                    String string = com.baidu.live.d.xc().getString("live_poke_start_anim", "");
                    if (TextUtils.isEmpty(string) || (Iu = b.Iu(string)) == null || !cfVar.downloadUrl.equals(Iu.downloadUrl) || !cfVar.aQJ.equals(Iu.aQJ) || TextUtils.isEmpty(Iu.videoMd5) || !Iu.videoMd5.equals(c.this.coF())) {
                        c.this.coG();
                        return null;
                    }
                    return Iu;
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
                    c.this.ifW = cfVar.videoPath;
                }
            }.execute(arVar.aNr);
        }
    }

    @Override // com.baidu.live.v.c
    public void release() {
        this.ifT = false;
        this.ifW = "";
        MessageManager.getInstance().unRegisterListener(this.ifU);
        this.ifU = null;
        if (this.ifV != null) {
            this.ifV.release();
        }
        com.baidu.live.h.b.cE(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cf> list) {
        if (list != null && !list.isEmpty()) {
            cf cfVar = list.get(0);
            this.ifW = cfVar.videoPath;
            com.baidu.live.d.xc().putString("live_poke_start_anim", b.a(cfVar));
        }
    }

    private void bWM() {
        if (this.ifU == null) {
            this.ifU = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.poke.startanim.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.Pj();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ifU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String coF() {
        File[] listFiles = new File(ifS).listFiles();
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
            this.ifV = new d();
            this.ifV.y(cfVar.downloadUrl, cfVar.aQJ, ifR, ifS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coG() {
        this.ifW = "";
        com.baidu.live.d.xc().putString("live_poke_start_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ifQ));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static c ifZ = new c();
    }
}
