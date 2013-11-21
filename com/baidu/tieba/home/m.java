package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<com.baidu.tieba.data.ad, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1448a;
    private com.baidu.tieba.util.ap b = null;
    private com.baidu.tieba.data.ad c;

    public m(EnterForumActivity enterForumActivity, com.baidu.tieba.data.ad adVar) {
        this.f1448a = enterForumActivity;
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
                    this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/c/forum/unfavo");
                    this.b.a("fid", adVar.a());
                    this.b.a("kw", adVar.b());
                    this.b.e(true);
                    this.b.j();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
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
        o oVar;
        super.a((m) str);
        this.f1448a.d = null;
        if (this.b != null) {
            if (this.b.c()) {
                baseFragmentActivity2 = this.f1448a.i;
                baseFragmentActivity2.a(this.f1448a.a(R.string.success));
                TiebaApplication.g().h(true);
                oVar = this.f1448a.c;
                oVar.e();
                return;
            }
            baseFragmentActivity = this.f1448a.i;
            baseFragmentActivity.a(this.b.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1448a.d = null;
        super.cancel(true);
    }
}
