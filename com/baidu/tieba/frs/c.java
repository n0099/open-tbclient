package com.baidu.tieba.frs;

import android.widget.ListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.as;
import java.util.ArrayList;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:17:0x007d */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0082  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ListView listView;
        ListView listView2;
        com.baidu.tieba.view.l lVar;
        int i;
        int i2;
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        int i3;
        ab abVar5;
        ab abVar6;
        ab abVar7;
        int i4;
        ab abVar8;
        ab abVar9;
        ab abVar10;
        ab abVar11;
        try {
            listView = this.a.v;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.v;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            lVar = this.a.K;
            if (lVar != null) {
                firstVisiblePosition--;
                lastVisiblePosition--;
                if (firstVisiblePosition < 0) {
                    firstVisiblePosition = 0;
                }
                if (lastVisiblePosition < 0) {
                    i = 0;
                    i2 = firstVisiblePosition;
                    com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
                    abVar = this.a.w;
                    abVar.a().a();
                    abVar2 = this.a.w;
                    abVar2.b().a();
                    boolean z = c != com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
                    abVar3 = this.a.w;
                    abVar3.a().a(z);
                    abVar4 = this.a.w;
                    abVar4.b().a(z);
                    i3 = i2;
                    int i5 = 0;
                    while (i3 < abVar5.getCount()) {
                        if (!z && i3 > i) {
                            return;
                        }
                        abVar6 = this.a.w;
                        as asVar = (as) abVar6.getItem(i3);
                        abVar7 = this.a.w;
                        if (abVar7.getItemId(i3) == -3) {
                            abVar11 = this.a.w;
                            asVar = abVar11.e();
                        }
                        if (asVar != null) {
                            ArrayList n = asVar.n();
                            int size = n.size();
                            if (i5 < 13) {
                                abVar8 = this.a.w;
                                if (abVar8.getItemId(i3) == -3) {
                                    int i6 = 0;
                                    while (true) {
                                        if (i6 >= size) {
                                            i4 = i5;
                                            break;
                                        }
                                        if (((com.baidu.tieba.a.af) n.get(i6)).a() == 3) {
                                            if (i5 >= 13) {
                                                i4 = i5;
                                                break;
                                            }
                                            i5++;
                                            abVar10 = this.a.w;
                                            abVar10.b().a(((com.baidu.tieba.a.af) n.get(i6)).b(), new d(this));
                                        }
                                        i6++;
                                        i5 = i5;
                                    }
                                } else if (TiebaApplication.a().ab()) {
                                    int i7 = 0;
                                    while (i7 < size) {
                                        if (((com.baidu.tieba.a.af) n.get(i7)).a() == 3) {
                                            if (i5 >= 13) {
                                                i4 = i5;
                                                break;
                                            }
                                            i5++;
                                            abVar9 = this.a.w;
                                            abVar9.a().a(((com.baidu.tieba.a.af) n.get(i7)).b(), new e(this));
                                        }
                                        i7++;
                                        i5 = i5;
                                    }
                                }
                                if (z && i4 >= 13 && 0 >= 30) {
                                    return;
                                }
                            }
                            i4 = i5;
                            if (z) {
                                return;
                            }
                            continue;
                        } else {
                            i4 = i5;
                        }
                        i3++;
                        i5 = i4;
                    }
                }
            }
            i = lastVisiblePosition;
            i2 = firstVisiblePosition;
            com.baidu.tieba.c.z c2 = com.baidu.tieba.c.w.c(this.a);
            abVar = this.a.w;
            abVar.a().a();
            abVar2 = this.a.w;
            abVar2.b().a();
            if (c2 != com.baidu.tieba.c.z.WIFI) {
            }
            abVar3 = this.a.w;
            abVar3.a().a(z);
            abVar4 = this.a.w;
            abVar4.b().a(z);
            i3 = i2;
            int i52 = 0;
            while (i3 < abVar5.getCount()) {
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
