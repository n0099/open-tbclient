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
/* loaded from: classes10.dex */
public class c implements com.baidu.live.v.c {
    private boolean ihC;
    private HttpMessageListener ihD;
    private d ihE;
    private String ihF;
    private static final String ihz = com.baidu.live.storage.b.QX();
    private static final String ihA = com.baidu.live.storage.b.Rc();
    private static final String ihB = com.baidu.live.storage.b.Rh();

    public static c coJ() {
        return a.ihI;
    }

    public String coK() {
        return this.ihF;
    }

    @Override // com.baidu.live.v.c
    public void Pm() {
        final ar arVar = com.baidu.live.ae.a.Qm().bwx;
        if (arVar == null || arVar.aOR == null || TextUtils.isEmpty(arVar.aOR.downloadUrl)) {
            bWS();
        } else if (!this.ihC) {
            this.ihF = "";
            this.ihC = true;
            new BdAsyncTask<cf, Void, cf>() { // from class: com.baidu.tieba.ala.poke.startanim.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public cf doInBackground(cf... cfVarArr) {
                    cf ID;
                    if (cfVarArr == null || cfVarArr.length == 0) {
                        return null;
                    }
                    cf cfVar = cfVarArr[0];
                    String string = com.baidu.live.d.xf().getString("live_poke_start_anim", "");
                    if (TextUtils.isEmpty(string) || (ID = b.ID(string)) == null || !cfVar.downloadUrl.equals(ID.downloadUrl) || !cfVar.aSj.equals(ID.aSj) || TextUtils.isEmpty(ID.videoMd5) || !ID.videoMd5.equals(c.this.coL())) {
                        c.this.coM();
                        return null;
                    }
                    return ID;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(cf cfVar) {
                    super.onPostExecute(cfVar);
                    if (cfVar == null) {
                        c.this.b(arVar.aOR);
                        return;
                    }
                    c.this.ihF = cfVar.videoPath;
                }
            }.execute(arVar.aOR);
        }
    }

    @Override // com.baidu.live.v.c
    public void release() {
        this.ihC = false;
        this.ihF = "";
        MessageManager.getInstance().unRegisterListener(this.ihD);
        this.ihD = null;
        if (this.ihE != null) {
            this.ihE.release();
        }
        com.baidu.live.h.b.cF(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(List<cf> list) {
        if (list != null && !list.isEmpty()) {
            cf cfVar = list.get(0);
            this.ihF = cfVar.videoPath;
            com.baidu.live.d.xf().putString("live_poke_start_anim", b.a(cfVar));
        }
    }

    private void bWS() {
        if (this.ihD == null) {
            this.ihD = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.poke.startanim.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.Pm();
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
    public void b(cf cfVar) {
        if (cfVar != null && !TextUtils.isEmpty(cfVar.downloadUrl)) {
            this.ihE = new d();
            this.ihE.y(cfVar.downloadUrl, cfVar.aSj, ihA, ihB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coM() {
        this.ihF = "";
        com.baidu.live.d.xf().putString("live_poke_start_anim", "");
        com.baidu.live.h.a.cleanDir(new File(ihz));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static c ihI = new c();
    }
}
