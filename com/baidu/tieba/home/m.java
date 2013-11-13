package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<com.baidu.tieba.data.ae, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1457a;
    private com.baidu.tieba.util.ap b = null;
    private com.baidu.tieba.data.ae c;

    public m(EnterForumActivity enterForumActivity, com.baidu.tieba.data.ae aeVar) {
        this.f1457a = enterForumActivity;
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
                    this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/c/forum/unfavo");
                    this.b.a("fid", aeVar.a());
                    this.b.a("kw", aeVar.b());
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
        this.f1457a.d = null;
        if (this.b != null) {
            if (this.b.c()) {
                baseFragmentActivity2 = this.f1457a.i;
                baseFragmentActivity2.a(this.f1457a.a(R.string.success));
                TiebaApplication.g().h(true);
                oVar = this.f1457a.c;
                oVar.e();
                return;
            }
            baseFragmentActivity = this.f1457a.i;
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
        this.f1457a.d = null;
        super.cancel(true);
    }
}
