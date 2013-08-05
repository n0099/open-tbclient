package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1155a;
    private com.baidu.tieba.util.u b = null;
    private com.baidu.tieba.data.ai c;

    public j(EnterForumActivity enterForumActivity, com.baidu.tieba.data.ai aiVar) {
        this.f1155a = enterForumActivity;
        this.c = null;
        this.c = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(com.baidu.tieba.data.ai... aiVarArr) {
        com.baidu.tieba.data.ai aiVar = this.c;
        if (aiVar != null) {
            try {
                if (aiVar.a() != null && aiVar.b() != null) {
                    this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/c/forum/unfavo");
                    this.b.a("fid", aiVar.a());
                    this.b.a("kw", aiVar.b());
                    this.b.e(true);
                    this.b.k();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.f1155a.b = null;
        if (this.b != null) {
            if (this.b.d()) {
                this.f1155a.a(this.f1155a.getString(R.string.success));
                TiebaApplication.f().j(true);
                this.f1155a.a(false);
                return;
            }
            this.f1155a.a(this.b.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        this.f1155a.b = null;
        super.cancel(true);
    }
}
