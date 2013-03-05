package com.baidu.tieba.frs;

import android.widget.ListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.at;
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
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        aa aaVar4;
        int i3;
        aa aaVar5;
        aa aaVar6;
        aa aaVar7;
        int i4;
        aa aaVar8;
        aa aaVar9;
        aa aaVar10;
        aa aaVar11;
        try {
            listView = this.a.x;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.x;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            lVar = this.a.M;
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
                    aaVar = this.a.y;
                    aaVar.a().a();
                    aaVar2 = this.a.y;
                    aaVar2.b().a();
                    boolean z = c != com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
                    aaVar3 = this.a.y;
                    aaVar3.a().a(z);
                    aaVar4 = this.a.y;
                    aaVar4.b().a(z);
                    i3 = i2;
                    int i5 = 0;
                    while (i3 < aaVar5.getCount()) {
                        if (z || i3 <= i) {
                            aaVar6 = this.a.y;
                            at atVar = (at) aaVar6.getItem(i3);
                            aaVar7 = this.a.y;
                            if (aaVar7.getItemId(i3) == -3) {
                                aaVar11 = this.a.y;
                                atVar = aaVar11.e();
                            }
                            if (atVar != null) {
                                ArrayList n = atVar.n();
                                int size = n.size();
                                if (i5 < 13) {
                                    aaVar8 = this.a.y;
                                    if (aaVar8.getItemId(i3) == -3) {
                                        int i6 = 0;
                                        while (true) {
                                            if (i6 >= size) {
                                                i4 = i5;
                                                break;
                                            }
                                            if (((com.baidu.tieba.a.ad) n.get(i6)).a() == 3) {
                                                if (i5 >= 13) {
                                                    i4 = i5;
                                                    break;
                                                }
                                                i5++;
                                                aaVar10 = this.a.y;
                                                aaVar10.b().a(((com.baidu.tieba.a.ad) n.get(i6)).b(), new d(this));
                                            }
                                            i6++;
                                            i5 = i5;
                                        }
                                    } else if (TiebaApplication.b().af()) {
                                        int i7 = 0;
                                        while (i7 < size) {
                                            if (((com.baidu.tieba.a.ad) n.get(i7)).a() == 3) {
                                                if (i5 >= 13) {
                                                    i4 = i5;
                                                    break;
                                                }
                                                i5++;
                                                aaVar9 = this.a.y;
                                                aaVar9.a().a(((com.baidu.tieba.a.ad) n.get(i7)).b(), new e(this));
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
                        } else {
                            return;
                        }
                    }
                }
            }
            i = lastVisiblePosition;
            i2 = firstVisiblePosition;
            com.baidu.tieba.c.z c2 = com.baidu.tieba.c.w.c(this.a);
            aaVar = this.a.y;
            aaVar.a().a();
            aaVar2 = this.a.y;
            aaVar2.b().a();
            if (c2 != com.baidu.tieba.c.z.WIFI) {
            }
            aaVar3 = this.a.y;
            aaVar3.a().a(z);
            aaVar4 = this.a.y;
            aaVar4.b().a(z);
            i3 = i2;
            int i52 = 0;
            while (i3 < aaVar5.getCount()) {
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
