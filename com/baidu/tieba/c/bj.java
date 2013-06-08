package com.baidu.tieba.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends com.baidu.adp.lib.a.a {
    final /* synthetic */ bi a;
    private com.baidu.tieba.d.t b;

    private bj(bi biVar) {
        this.a = biVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bj(bi biVar, bj bjVar) {
        this(biVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(Integer... numArr) {
        try {
            int intValue = numArr[0].intValue();
            if (this.a.f() != null) {
                this.b = new com.baidu.tieba.d.t();
                if (intValue == 0) {
                    this.b.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/user/follow");
                } else {
                    this.b.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/user/unfollow");
                }
                this.b.a("portrait", this.a.f().e());
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) str);
        this.a.q = null;
        if (this.b != null) {
            if (!this.b.b()) {
                this.a.a = 3;
                this.a.a(this.b.f());
                eVar = this.a.b;
                eVar.a(false);
                return;
            }
            if (this.a.f() != null) {
                if (this.a.f().o() == 1) {
                    this.a.f().c(0);
                } else {
                    this.a.f().c(1);
                }
            }
            this.a.a = 3;
            eVar2 = this.a.b;
            eVar2.a(true);
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.q = null;
        super.cancel(true);
        eVar = this.a.b;
        eVar.a(false);
    }
}
