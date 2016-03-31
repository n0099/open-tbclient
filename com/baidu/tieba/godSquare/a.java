package com.baidu.tieba.godSquare;

import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes.dex */
class a implements b.a {
    final /* synthetic */ GodSquareActivity bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GodSquareActivity godSquareActivity) {
        this.bJY = godSquareActivity;
    }

    @Override // com.baidu.tieba.godSquare.model.b.a
    public void a(List<u> list, boolean z, boolean z2, String str) {
        d dVar;
        d dVar2;
        d dVar3;
        com.baidu.tieba.godSquare.model.b bVar;
        d dVar4;
        d dVar5;
        d dVar6;
        com.baidu.tieba.godSquare.model.b bVar2;
        d dVar7;
        com.baidu.tieba.godSquare.model.b bVar3;
        d dVar8;
        com.baidu.tieba.godSquare.model.b bVar4;
        d dVar9;
        this.bJY.mHasMore = z2;
        dVar = this.bJY.bJU;
        dVar.XZ().nj();
        dVar2 = this.bJY.bJU;
        dVar2.XX();
        if (y.q(list)) {
            dVar8 = this.bJY.bJU;
            dVar8.Yb();
            bVar4 = this.bJY.bJV;
            if (y.q(bVar4.bKm)) {
                dVar9 = this.bJY.bJU;
                dVar9.in(str);
                return;
            }
            this.bJY.mHasMore = true;
            if (k.jw()) {
                this.bJY.showToast(str);
                return;
            }
            return;
        }
        dVar3 = this.bJY.bJU;
        dVar3.XY();
        if (z) {
            bVar2 = this.bJY.bJV;
            bVar2.bKm = list;
            dVar7 = this.bJY.bJU;
            bVar3 = this.bJY.bJV;
            dVar7.aQ(bVar3.bKm);
        } else {
            bVar = this.bJY.bJV;
            bVar.bKm.addAll(list);
            dVar4 = this.bJY.bJU;
            dVar4.notifyDataSetChanged();
        }
        if (z2) {
            dVar6 = this.bJY.bJU;
            dVar6.Ya();
            return;
        }
        dVar5 = this.bJY.bJU;
        dVar5.Yc();
    }
}
