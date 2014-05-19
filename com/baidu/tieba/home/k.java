package com.baidu.tieba.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.ad;
import com.baidu.tieba.data.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<x, Integer, String> {
    final /* synthetic */ e a;
    private al b = null;
    private x c;

    public k(e eVar, x xVar) {
        this.a = eVar;
        this.c = null;
        this.c = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(x... xVarArr) {
        x xVar = this.c;
        if (xVar != null) {
            try {
                if (xVar.a() != null && xVar.b() != null) {
                    this.b = new al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                    this.b.a("fid", xVar.a());
                    this.b.a("kw", xVar.b());
                    this.b.a().a().a = true;
                    this.b.i();
                    return null;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.tbadk.core.e eVar;
        com.baidu.tbadk.core.e eVar2;
        p pVar;
        super.onPostExecute(str);
        this.a.c = null;
        if (this.b != null) {
            if (this.b.a().b().b()) {
                eVar2 = this.a.h;
                eVar2.a(this.a.getString(com.baidu.tieba.u.success));
                ad.c().e(true);
                pVar = this.a.b;
                pVar.b();
                MessageManager.getInstance().sendMessage(new CustomMessage(2005004, this.c.a()));
                return;
            }
            eVar = this.a.h;
            eVar.a(this.b.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.c = null;
        super.cancel(true);
    }
}
