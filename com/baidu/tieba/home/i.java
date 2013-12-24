package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<com.baidu.tieba.data.ad, Integer, String> {
    final /* synthetic */ EnterForumActivity a;
    private com.baidu.tieba.util.an b = null;
    private com.baidu.tieba.data.ad c;

    public i(EnterForumActivity enterForumActivity, com.baidu.tieba.data.ad adVar) {
        this.a = enterForumActivity;
        this.c = null;
        this.c = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(com.baidu.tieba.data.ad... adVarArr) {
        com.baidu.tieba.data.ad adVar = this.c;
        if (adVar != null) {
            try {
                if (adVar.a() != null && adVar.b() != null) {
                    this.b = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/c/forum/unfavo");
                    this.b.a("fid", adVar.a());
                    this.b.a("kw", adVar.b());
                    this.b.e(true);
                    this.b.l();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        k kVar;
        super.a((i) str);
        this.a.b = null;
        if (this.b != null) {
            if (this.b.c()) {
                baseFragmentActivity2 = this.a.g;
                baseFragmentActivity2.a(this.a.a(R.string.success));
                TiebaApplication.h().h(true);
                kVar = this.a.a;
                kVar.e();
                return;
            }
            baseFragmentActivity = this.a.g;
            baseFragmentActivity.a(this.b.i());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.a.b = null;
        super.cancel(true);
    }
}
