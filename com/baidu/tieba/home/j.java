package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f931a;
    private com.baidu.tieba.util.r b = null;
    private com.baidu.tieba.data.aa c;

    public j(EnterForumActivity enterForumActivity, com.baidu.tieba.data.aa aaVar) {
        this.f931a = enterForumActivity;
        this.c = null;
        this.c = aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(com.baidu.tieba.data.aa... aaVarArr) {
        com.baidu.tieba.data.aa aaVar = this.c;
        if (aaVar != null) {
            try {
                if (aaVar.a() != null && aaVar.b() != null) {
                    this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/forum/unfavo");
                    this.b.a("fid", aaVar.a());
                    this.b.a("kw", aaVar.b());
                    this.b.d(true);
                    this.b.j();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((Object) str);
        this.f931a.b = null;
        if (this.b != null) {
            if (this.b.c()) {
                this.f931a.a(this.f931a.getString(R.string.success));
                TiebaApplication.f().i(true);
                this.f931a.a(false);
                return;
            }
            this.f931a.a(this.b.g());
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
        this.f931a.b = null;
        super.cancel(true);
    }
}
