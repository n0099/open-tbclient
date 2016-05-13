package com.baidu.tieba.godSquare;

import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes.dex */
class a implements b.a {
    final /* synthetic */ GodSquareActivity bKe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GodSquareActivity godSquareActivity) {
        this.bKe = godSquareActivity;
    }

    @Override // com.baidu.tieba.godSquare.model.b.a
    public void a(List<v> list, boolean z, boolean z2, String str) {
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
        this.bKe.mHasMore = z2;
        dVar = this.bKe.bKa;
        dVar.getListView().k(2000L);
        dVar2 = this.bKe.bKa;
        dVar2.Pf();
        if (y.s(list)) {
            dVar8 = this.bKe.bKa;
            dVar8.XY();
            bVar4 = this.bKe.bKb;
            if (y.s(bVar4.bdt)) {
                dVar9 = this.bKe.bKa;
                dVar9.hF(str);
                return;
            }
            this.bKe.mHasMore = true;
            if (k.fH()) {
                this.bKe.showToast(str);
                return;
            }
            return;
        }
        dVar3 = this.bKe.bKa;
        dVar3.Pg();
        if (z) {
            bVar2 = this.bKe.bKb;
            bVar2.bdt = list;
            dVar7 = this.bKe.bKa;
            bVar3 = this.bKe.bKb;
            dVar7.aO(bVar3.bdt);
        } else {
            bVar = this.bKe.bKb;
            bVar.bdt.addAll(list);
            dVar4 = this.bKe.bKa;
            dVar4.notifyDataSetChanged();
        }
        if (z2) {
            dVar6 = this.bKe.bKa;
            dVar6.XX();
            return;
        }
        dVar5 = this.bKe.bKa;
        dVar5.XZ();
    }
}
