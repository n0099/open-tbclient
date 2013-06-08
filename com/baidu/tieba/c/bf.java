package com.baidu.tieba.c;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.lib.a.a {
    final /* synthetic */ bd a;
    private com.baidu.tieba.b.f b = null;
    private String c = null;
    private boolean d = false;

    public bf(bd bdVar) {
        this.a = bdVar;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(Integer... numArr) {
        com.baidu.tieba.a.bi biVar;
        boolean z;
        if (this.d) {
            return null;
        }
        this.b = new com.baidu.tieba.b.f();
        com.baidu.tieba.b.f fVar = this.b;
        biVar = this.a.f;
        z = this.a.h;
        this.c = fVar.a(biVar, z);
        return this.c;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        be beVar;
        be beVar2;
        this.d = true;
        if (this.b != null) {
            this.b.d();
        }
        beVar = this.a.g;
        if (beVar != null) {
            beVar2 = this.a.g;
            beVar2.a(false, null, null, null);
        }
        super.cancel(true);
        this.a.e = null;
    }

    private void a(int i, String str) {
        be beVar;
        be beVar2;
        com.baidu.tieba.a.bi biVar;
        com.baidu.tieba.a.bi biVar2;
        com.baidu.tieba.a.bi biVar3;
        be beVar3;
        be beVar4;
        com.baidu.tieba.a.bi biVar4;
        be beVar5;
        be beVar6;
        if (i != 5 && i != 6) {
            beVar5 = this.a.g;
            if (beVar5 != null) {
                beVar6 = this.a.g;
                beVar6.a(false, str, null, null);
                return;
            }
            return;
        }
        com.baidu.tieba.a.bf bfVar = new com.baidu.tieba.a.bf();
        bfVar.a(this.c);
        if (bfVar.b() != null) {
            biVar = this.a.f;
            if (biVar != null) {
                biVar2 = this.a.f;
                biVar2.h(bfVar.a());
                biVar3 = this.a.f;
                biVar3.i(bfVar.b());
                beVar3 = this.a.g;
                if (beVar3 != null) {
                    beVar4 = this.a.g;
                    biVar4 = this.a.f;
                    beVar4.a(false, str, bfVar, biVar4);
                    return;
                }
                return;
            }
        }
        beVar = this.a.g;
        if (beVar != null) {
            beVar2 = this.a.g;
            beVar2.a(false, str, null, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        be beVar;
        be beVar2;
        be beVar3;
        super.a((Object) str);
        com.baidu.tieba.d.ae.e(getClass().getName(), "onPostExecute", "result:" + str);
        this.a.e = null;
        if (!this.d) {
            if (str == null) {
                beVar = this.a.g;
                beVar.a(false, TiebaApplication.d().getString(R.string.neterror), null, null);
            } else if (this.b.a()) {
                com.baidu.tieba.a.o oVar = new com.baidu.tieba.a.o();
                oVar.b(this.c);
                if (oVar.b() == null || oVar.b().length() <= 0) {
                    oVar.a(TiebaApplication.d().getString(R.string.send_success));
                    beVar2 = this.a.g;
                    if (beVar2 != null) {
                        beVar3 = this.a.g;
                        beVar3.a(true, oVar.b(), null, null);
                        return;
                    }
                    return;
                }
                a(oVar.a(), oVar.b());
            } else {
                a(this.b.b(), this.b.c());
            }
        }
    }
}
