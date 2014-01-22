package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<com.baidu.tieba.data.ae, Integer, String> {
    final /* synthetic */ EnterForumActivity a;
    private com.baidu.tieba.util.ax b = null;
    private com.baidu.tieba.data.ae c;

    public j(EnterForumActivity enterForumActivity, com.baidu.tieba.data.ae aeVar) {
        this.a = enterForumActivity;
        this.c = null;
        this.c = aeVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(com.baidu.tieba.data.ae... aeVarArr) {
        com.baidu.tieba.data.ae aeVar = this.c;
        if (aeVar != null) {
            try {
                if (aeVar.a() != null && aeVar.b() != null) {
                    this.b = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/c/forum/unfavo");
                    this.b.a("fid", aeVar.a());
                    this.b.a("kw", aeVar.b());
                    this.b.e(true);
                    this.b.m();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.getMessage());
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
        l lVar;
        super.a((j) str);
        this.a.b = null;
        if (this.b != null) {
            if (this.b.d()) {
                baseFragmentActivity2 = this.a.g;
                baseFragmentActivity2.a(this.a.a(R.string.success));
                TiebaApplication.h().h(true);
                lVar = this.a.a;
                lVar.e();
                return;
            }
            baseFragmentActivity = this.a.g;
            baseFragmentActivity.a(this.b.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.k();
            this.b = null;
        }
        this.a.b = null;
        super.cancel(true);
    }
}
