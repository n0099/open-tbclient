package com.baidu.tieba.home;

import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.lib.a.a {
    final /* synthetic */ EnterForumActivity a;
    private com.baidu.tieba.d.t b = null;
    private com.baidu.tieba.a.p c;

    public k(EnterForumActivity enterForumActivity, com.baidu.tieba.a.p pVar) {
        this.a = enterForumActivity;
        this.c = null;
        this.c = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(com.baidu.tieba.a.p... pVarArr) {
        com.baidu.tieba.a.p pVar = this.c;
        if (pVar != null) {
            try {
                if (pVar.a() != null && pVar.b() != null) {
                    this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/forum/unfavo");
                    this.b.a("fid", pVar.a());
                    this.b.a("kw", pVar.b());
                    this.b.a("favo_type", String.valueOf(pVar.e()));
                    this.b.d(true);
                    this.b.i();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        com.baidu.tieba.c.g gVar;
        super.a((Object) str);
        this.a.f = null;
        if (this.b != null) {
            if (this.b.b()) {
                gVar = this.a.d;
                ArrayList c = gVar.d().c();
                if (c != null) {
                    c.remove(this.c);
                    this.a.o();
                }
                this.a.a(this.a.getString(R.string.success));
                return;
            }
            this.a.a(this.b.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.f = null;
        super.cancel(true);
    }
}
