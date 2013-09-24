package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<com.baidu.tieba.data.ae, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1218a;
    private com.baidu.tieba.util.z b = null;
    private com.baidu.tieba.data.ae c;

    public i(EnterForumActivity enterForumActivity, com.baidu.tieba.data.ae aeVar) {
        this.f1218a = enterForumActivity;
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
                    this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/forum/unfavo");
                    this.b.a("fid", aeVar.a());
                    this.b.a("kw", aeVar.b());
                    this.b.e(true);
                    this.b.j();
                    return null;
                }
                return null;
            } catch (Exception e) {
                av.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        k kVar;
        super.a((i) str);
        this.f1218a.b = null;
        if (this.b != null) {
            if (this.b.c()) {
                this.f1218a.a(this.f1218a.getString(R.string.success));
                TiebaApplication.g().h(true);
                kVar = this.f1218a.f1185a;
                kVar.b();
                return;
            }
            this.f1218a.a(this.b.g());
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
        this.f1218a.b = null;
        super.cancel(true);
    }
}
