package com.baidu.tieba.c;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.lib.a.a {
    com.baidu.tieba.b.c a;
    String b;
    final /* synthetic */ ba c;

    private bc(ba baVar) {
        this.c = baVar;
        this.a = null;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bc(ba baVar, bc bcVar) {
        this(baVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(Integer... numArr) {
        com.baidu.tieba.a.bh bhVar;
        boolean z;
        this.a = new com.baidu.tieba.b.c();
        com.baidu.tieba.b.c cVar = this.a;
        bhVar = this.c.f;
        z = this.c.h;
        this.b = cVar.a(bhVar, z);
        return this.b;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        bb bbVar;
        bb bbVar2;
        if (this.a != null) {
            this.a.d();
        }
        bbVar = this.c.g;
        if (bbVar != null) {
            bbVar2 = this.c.g;
            bbVar2.a(false, null, null, null);
        }
        super.cancel(true);
    }

    private void a(int i, String str) {
        bb bbVar;
        bb bbVar2;
        com.baidu.tieba.a.bh bhVar;
        com.baidu.tieba.a.bh bhVar2;
        bb bbVar3;
        bb bbVar4;
        com.baidu.tieba.a.bh bhVar3;
        bb bbVar5;
        bb bbVar6;
        if (i != 5 && i != 6) {
            bbVar5 = this.c.g;
            if (bbVar5 != null) {
                bbVar6 = this.c.g;
                bbVar6.a(false, str, null, null);
                return;
            }
            return;
        }
        com.baidu.tieba.a.be beVar = new com.baidu.tieba.a.be();
        beVar.a(this.b);
        if (beVar.b() != null) {
            bhVar = this.c.f;
            bhVar.h(beVar.a());
            bhVar2 = this.c.f;
            bhVar2.i(beVar.b());
            bbVar3 = this.c.g;
            if (bbVar3 != null) {
                bbVar4 = this.c.g;
                bhVar3 = this.c.f;
                bbVar4.a(false, str, beVar, bhVar3);
                return;
            }
            return;
        }
        bbVar = this.c.g;
        if (bbVar != null) {
            bbVar2 = this.c.g;
            bbVar2.a(false, str, null, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        bb bbVar;
        bb bbVar2;
        bb bbVar3;
        com.baidu.tieba.d.ae.e(getClass().getName(), "onPostExecute", "result:" + str);
        this.c.e = null;
        if (str == null) {
            bbVar = this.c.g;
            bbVar.a(false, TiebaApplication.d().getString(R.string.neterror), null, null);
        } else if (this.a.a()) {
            com.baidu.tieba.a.o oVar = new com.baidu.tieba.a.o();
            oVar.b(this.b);
            if (oVar.b() == null || oVar.b().length() <= 0) {
                oVar.a(TiebaApplication.d().getString(R.string.send_success));
                bbVar2 = this.c.g;
                if (bbVar2 != null) {
                    bbVar3 = this.c.g;
                    bbVar3.a(true, oVar.b(), null, null);
                }
            } else {
                a(oVar.a(), oVar.b());
            }
        } else {
            a(this.a.b(), this.a.c());
        }
        super.a((Object) str);
    }
}
