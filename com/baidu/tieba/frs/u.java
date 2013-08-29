package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1114a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.f1114a = frsActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:18:0x0084 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        bb bbVar;
        bb bbVar2;
        bb bbVar3;
        bb bbVar4;
        bb bbVar5;
        String str;
        String str2;
        com.baidu.tieba.model.aa aaVar;
        bb bbVar6;
        bb bbVar7;
        int i;
        bb bbVar8;
        try {
            bbVar = this.f1114a.l;
            int e = bbVar.e();
            bbVar2 = this.f1114a.l;
            int i2 = e - 2;
            int f = bbVar2.f() - 2;
            if (i2 < 0) {
                i2 = 0;
            }
            int i3 = f < 0 ? 0 : f;
            UtilHelper.NetworkStateInfo i4 = UtilHelper.i(this.f1114a);
            bbVar3 = this.f1114a.l;
            bbVar3.i().a().a();
            bbVar4 = this.f1114a.l;
            bbVar4.k().a().a();
            bbVar5 = this.f1114a.l;
            bbVar5.j().a().a();
            boolean z = i4 == UtilHelper.NetworkStateInfo.WIFI || i4 == UtilHelper.NetworkStateInfo.ThreeG;
            str = this.f1114a.A;
            if (str != "frs_page") {
                str2 = this.f1114a.A;
                if (str2 == "normal_page") {
                    aaVar = this.f1114a.v;
                    String n = aaVar.a().n();
                    if (n != null && n.length() > 0) {
                        this.f1114a.b();
                    }
                }
            } else {
                this.f1114a.c();
            }
            int i5 = i2;
            int i6 = 0;
            while (i5 < bbVar6.i().getCount()) {
                if (z || i5 <= i3) {
                    bbVar7 = this.f1114a.l;
                    com.baidu.tieba.data.bh bhVar = (com.baidu.tieba.data.bh) bbVar7.i().getItem(i5);
                    if (bhVar != null) {
                        ArrayList m = bhVar.m();
                        int size = m.size();
                        int i7 = size > 3 ? 3 : size;
                        if (i6 < 13 && TiebaApplication.g().al()) {
                            int i8 = 0;
                            while (i8 < i7) {
                                if (((com.baidu.tieba.data.ai) m.get(i8)).a() == 3) {
                                    if (i6 >= 13) {
                                        i = i6;
                                        break;
                                    }
                                    i6++;
                                    bbVar8 = this.f1114a.l;
                                    bbVar8.i().a().a(((com.baidu.tieba.data.ai) m.get(i8)).b(), new v(this));
                                }
                                i8++;
                                i6 = i6;
                            }
                        }
                        i = i6;
                        if (z && i >= 13 && 0 >= 30) {
                            return;
                        }
                    } else {
                        i = i6;
                    }
                    i5++;
                    i6 = i;
                } else {
                    return;
                }
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.aq.b("FrsActivity", "mGetImageRunnble.run", "error = " + e2.getMessage());
        }
    }
}
