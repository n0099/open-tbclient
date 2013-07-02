package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.NetWorkCore;
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
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        az azVar5;
        String str;
        String str2;
        com.baidu.tieba.model.v vVar;
        az azVar6;
        az azVar7;
        int i;
        az azVar8;
        try {
            azVar = this.a.l;
            int c = azVar.c();
            azVar2 = this.a.l;
            int i2 = c - 2;
            int d = azVar2.d() - 2;
            if (i2 < 0) {
                i2 = 0;
            }
            int i3 = d < 0 ? 0 : d;
            NetWorkCore.NetworkStateInfo c2 = NetWorkCore.c(this.a);
            azVar3 = this.a.l;
            azVar3.g().a().a();
            azVar4 = this.a.l;
            azVar4.i().a().a();
            azVar5 = this.a.l;
            azVar5.h().a().a();
            boolean z = c2 == NetWorkCore.NetworkStateInfo.WIFI || c2 == NetWorkCore.NetworkStateInfo.ThreeG;
            str = this.a.A;
            if (str != "frs_page") {
                str2 = this.a.A;
                if (str2 == "normal_page") {
                    vVar = this.a.v;
                    String l = vVar.a().l();
                    if (l != null && l.length() > 0) {
                        this.a.b();
                    }
                }
            } else {
                this.a.c();
            }
            int i4 = i2;
            int i5 = 0;
            while (i4 < azVar6.g().getCount()) {
                if (z || i4 <= i3) {
                    azVar7 = this.a.l;
                    com.baidu.tieba.data.ba baVar = (com.baidu.tieba.data.ba) azVar7.g().getItem(i4);
                    if (baVar != null) {
                        ArrayList m = baVar.m();
                        int size = m.size();
                        if (i5 < 13 && TiebaApplication.f().ar()) {
                            int i6 = 0;
                            while (i6 < size) {
                                if (((com.baidu.tieba.data.ae) m.get(i6)).a() == 3) {
                                    if (i5 >= 13) {
                                        i = i5;
                                        break;
                                    }
                                    i5++;
                                    azVar8 = this.a.l;
                                    azVar8.g().a().a(((com.baidu.tieba.data.ae) m.get(i6)).b(), new t(this));
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
            com.baidu.tieba.util.z.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
