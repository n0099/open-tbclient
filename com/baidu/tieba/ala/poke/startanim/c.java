package com.baidu.tieba.ala.poke.startanim;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.an;
import com.baidu.live.data.by;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import java.io.File;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements com.baidu.live.w.c {
    private static final String ifP = com.baidu.live.ah.b.Tl();
    private static final String ifQ = com.baidu.live.ah.b.Tn();
    private static final String ifR = com.baidu.live.ah.b.Tp();
    private boolean ifS;
    private HttpMessageListener ifT;
    private d ifU;
    private String ifV;

    public static c crq() {
        return a.ifY;
    }

    public String crr() {
        return this.ifV;
    }

    @Override // com.baidu.live.w.c
    public void RC() {
        final an anVar = com.baidu.live.af.a.SE().bwi;
        if (anVar == null || anVar.aPo == null || TextUtils.isEmpty(anVar.aPo.downloadUrl)) {
            bZT();
        } else if (!this.ifS) {
            this.ifV = "";
            this.ifS = true;
            new BdAsyncTask<by, Void, by>() { // from class: com.baidu.tieba.ala.poke.startanim.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public by doInBackground(by... byVarArr) {
                    by Ja;
                    if (byVarArr == null || byVarArr.length == 0) {
                        return null;
                    }
                    by byVar = byVarArr[0];
                    String string = com.baidu.live.d.Ba().getString("live_poke_start_anim", "");
                    if (TextUtils.isEmpty(string) || (Ja = b.Ja(string)) == null || !byVar.downloadUrl.equals(Ja.downloadUrl) || !byVar.aSv.equals(Ja.aSv) || TextUtils.isEmpty(Ja.videoMd5) || !Ja.videoMd5.equals(c.this.crs())) {
                        c.this.crt();
                        return null;
                    }
                    return Ja;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(by byVar) {
                    super.onPostExecute(byVar);
                    if (byVar == null) {
                        c.this.b(anVar.aPo);
                        return;
                    }
                    c.this.ifV = byVar.videoPath;
                }
            }.execute(anVar.aPo);
        }
    }

    @Override // com.baidu.live.w.c
    public void release() {
        this.ifS = false;
        this.ifV = "";
        MessageManager.getInstance().unRegisterListener(this.ifT);
        this.ifT = null;
        if (this.ifU != null) {
            this.ifU.release();
        }
        com.baidu.live.i.b.ef(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cQ(List<by> list) {
        if (list != null && !list.isEmpty()) {
            by byVar = list.get(0);
            this.ifV = byVar.videoPath;
            com.baidu.live.d.Ba().putString("live_poke_start_anim", b.a(byVar));
        }
    }

    private void bZT() {
        if (this.ifT == null) {
            this.ifT = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.poke.startanim.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.RC();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ifT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String crs() {
        File[] listFiles = new File(ifR).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        for (File file : listFiles) {
            if (!file.isDirectory()) {
                return com.baidu.live.i.a.getFileMd5(file);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(by byVar) {
        if (byVar != null && !TextUtils.isEmpty(byVar.downloadUrl)) {
            this.ifU = new d();
            this.ifU.y(byVar.downloadUrl, byVar.aSv, ifQ, ifR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crt() {
        this.ifV = "";
        com.baidu.live.d.Ba().putString("live_poke_start_anim", "");
        com.baidu.live.i.a.cleanDir(new File(ifP));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static c ifY = new c();
    }
}
