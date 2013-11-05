package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<com.baidu.tieba.data.ae, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1361a;
    private com.baidu.tieba.util.ag b = null;
    private com.baidu.tieba.data.ae c;

    public l(EnterForumActivity enterForumActivity, com.baidu.tieba.data.ae aeVar) {
        this.f1361a = enterForumActivity;
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
                    this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/c/forum/unfavo");
                    this.b.a("fid", aeVar.a());
                    this.b.a("kw", aeVar.b());
                    this.b.e(true);
                    this.b.j();
                    return null;
                }
                return null;
            } catch (Exception e) {
                be.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        n nVar;
        super.a((l) str);
        this.f1361a.d = null;
        if (this.b != null) {
            if (this.b.c()) {
                this.f1361a.a(this.f1361a.getString(R.string.success));
                TiebaApplication.g().h(true);
                nVar = this.f1361a.c;
                nVar.e();
                return;
            }
            this.f1361a.a(this.b.g());
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
        this.f1361a.d = null;
        super.cancel(true);
    }
}
