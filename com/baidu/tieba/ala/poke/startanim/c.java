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
/* loaded from: classes10.dex */
public class c implements com.baidu.live.w.c {
    private static final String ibe = com.baidu.live.ah.b.Pq();
    private static final String ibf = com.baidu.live.ah.b.Ps();
    private static final String ibg = com.baidu.live.ah.b.Pu();
    private boolean ibh;
    private HttpMessageListener ibi;
    private d ibj;
    private String ibk;

    public static c cny() {
        return a.ibn;
    }

    public String cnz() {
        return this.ibk;
    }

    @Override // com.baidu.live.w.c
    public void NH() {
        final an anVar = com.baidu.live.af.a.OJ().bru;
        if (anVar == null || anVar.aKB == null || TextUtils.isEmpty(anVar.aKB.downloadUrl)) {
            bWb();
        } else if (!this.ibh) {
            this.ibk = "";
            this.ibh = true;
            new BdAsyncTask<by, Void, by>() { // from class: com.baidu.tieba.ala.poke.startanim.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public by doInBackground(by... byVarArr) {
                    by HP;
                    if (byVarArr == null || byVarArr.length == 0) {
                        return null;
                    }
                    by byVar = byVarArr[0];
                    String string = com.baidu.live.d.xf().getString("live_poke_start_anim", "");
                    if (TextUtils.isEmpty(string) || (HP = b.HP(string)) == null || !byVar.downloadUrl.equals(HP.downloadUrl) || !byVar.aNI.equals(HP.aNI) || TextUtils.isEmpty(HP.videoMd5) || !HP.videoMd5.equals(c.this.cnA())) {
                        c.this.cnB();
                        return null;
                    }
                    return HP;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public void onPostExecute(by byVar) {
                    super.onPostExecute(byVar);
                    if (byVar == null) {
                        c.this.b(anVar.aKB);
                        return;
                    }
                    c.this.ibk = byVar.videoPath;
                }
            }.execute(anVar.aKB);
        }
    }

    @Override // com.baidu.live.w.c
    public void release() {
        this.ibh = false;
        this.ibk = "";
        MessageManager.getInstance().unRegisterListener(this.ibi);
        this.ibi = null;
        if (this.ibj != null) {
            this.ibj.release();
        }
        com.baidu.live.i.b.cz(21);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cQ(List<by> list) {
        if (list != null && !list.isEmpty()) {
            by byVar = list.get(0);
            this.ibk = byVar.videoPath;
            com.baidu.live.d.xf().putString("live_poke_start_anim", b.a(byVar));
        }
    }

    private void bWb() {
        if (this.ibi == null) {
            this.ibi = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.poke.startanim.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        c.this.NH();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ibi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cnA() {
        File[] listFiles = new File(ibg).listFiles();
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
            this.ibj = new d();
            this.ibj.y(byVar.downloadUrl, byVar.aNI, ibf, ibg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnB() {
        this.ibk = "";
        com.baidu.live.d.xf().putString("live_poke_start_anim", "");
        com.baidu.live.i.a.cleanDir(new File(ibe));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static c ibn = new c();
    }
}
