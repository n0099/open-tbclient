package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:18:0x0083 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ba baVar;
        ba baVar2;
        ba baVar3;
        ba baVar4;
        ba baVar5;
        String str;
        String str2;
        com.baidu.tieba.c.p pVar;
        ba baVar6;
        ba baVar7;
        int i;
        ba baVar8;
        try {
            baVar = this.a.l;
            int c = baVar.c();
            baVar2 = this.a.l;
            int i2 = c - 2;
            int d = baVar2.d() - 2;
            if (i2 < 0) {
                i2 = 0;
            }
            int i3 = d < 0 ? 0 : d;
            com.baidu.tieba.d.z c2 = com.baidu.tieba.d.w.c(this.a);
            baVar3 = this.a.l;
            baVar3.g().a().a();
            baVar4 = this.a.l;
            baVar4.i().a().a();
            baVar5 = this.a.l;
            baVar5.h().a().a();
            boolean z = c2 == com.baidu.tieba.d.z.WIFI || c2 == com.baidu.tieba.d.z.ThreeG;
            str = this.a.A;
            if (str != "frs_page") {
                str2 = this.a.A;
                if (str2 == "normal_page") {
                    pVar = this.a.v;
                    String l = pVar.a().l();
                    if (l != null && l.length() > 0) {
                        this.a.b();
                    }
                }
            } else {
                this.a.c();
            }
            int i4 = i2;
            int i5 = 0;
            while (i4 < baVar6.g().getCount()) {
                if (z || i4 <= i3) {
                    baVar7 = this.a.l;
                    com.baidu.tieba.a.bb bbVar = (com.baidu.tieba.a.bb) baVar7.g().getItem(i4);
                    if (bbVar != null) {
                        ArrayList m = bbVar.m();
                        int size = m.size();
                        if (i5 < 13 && TiebaApplication.d().ah()) {
                            int i6 = 0;
                            while (i6 < size) {
                                if (((com.baidu.tieba.a.ag) m.get(i6)).a() == 3) {
                                    if (i5 >= 13) {
                                        i = i5;
                                        break;
                                    }
                                    i5++;
                                    baVar8 = this.a.l;
                                    baVar8.g().a().a(((com.baidu.tieba.a.ag) m.get(i6)).b(), new t(this));
                                }
                                i6++;
                                i5 = i5;
                            }
                        }
                        i = i5;
                        if (z && i >= 13 && 0 >= 30) {
                            return;
                        }
                    } else {
                        i = i5;
                    }
                    i4++;
                    i5 = i;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
