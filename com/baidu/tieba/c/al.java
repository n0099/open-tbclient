package com.baidu.tieba.c;

import com.baidu.android.pushservice.PushConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.adp.lib.a.a {
    final /* synthetic */ ak a;
    private com.baidu.tieba.d.t b = null;
    private boolean c;
    private com.baidu.tieba.a.ba d;

    public al(ak akVar, boolean z) {
        this.a = akVar;
        this.c = true;
        this.d = null;
        this.c = z;
        this.d = new com.baidu.tieba.a.ba();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Boolean a(Boolean... boolArr) {
        com.baidu.tieba.a.af afVar;
        com.baidu.tieba.a.af afVar2;
        com.baidu.tieba.a.af afVar3;
        if (this.c) {
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/post/addstore");
            f fVar = new f();
            afVar3 = this.a.f;
            fVar.a(afVar3);
            this.b.a("data", fVar.a(0, 1));
        } else {
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/post/rmstore");
            com.baidu.tieba.d.t tVar = this.b;
            afVar = this.a.f;
            tVar.a(PushConstants.EXTRA_USER_ID, afVar.h());
            com.baidu.tieba.d.t tVar2 = this.b;
            afVar2 = this.a.f;
            tVar2.a("tid", afVar2.c());
        }
        this.d.a(this.b.i());
        boolean z = this.d.a() == 0;
        if (this.b.b() && z) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.g = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        am amVar;
        am amVar2;
        am amVar3;
        am amVar4;
        am amVar5;
        if (bool.booleanValue()) {
            amVar4 = this.a.h;
            if (amVar4 != null) {
                amVar5 = this.a.h;
                amVar5.a(true, this.c, null);
            }
        } else {
            amVar = this.a.h;
            if (amVar != null) {
                if (this.b == null || this.b.b()) {
                    amVar2 = this.a.h;
                    amVar2.a(false, this.c, this.d.b());
                } else {
                    amVar3 = this.a.h;
                    amVar3.a(false, this.c, this.b.f());
                }
            }
        }
        this.a.g = null;
    }
}
