package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class t implements ce {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.bzl = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, co coVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.tieba.frs.entelechy.b.b bVar;
        ce ceVar;
        ce ceVar2;
        com.baidu.tieba.frs.h.s sVar;
        com.baidu.tieba.frs.entelechy.b.b bVar2;
        this.bzl.Wr();
        bVar = this.bzl.byE;
        if (bVar != null) {
            sVar = this.bzl.bys;
            bVar2 = this.bzl.byE;
            sVar.ef(bVar2.ho(i));
        }
        d.a aVar = new d.a();
        if (coVar != null) {
            aVar.isSuccess = coVar.errCode == 0;
            aVar.errorCode = coVar.errCode;
            aVar.errorMsg = coVar.errMsg;
            if (aVar.isSuccess) {
                if (com.baidu.tbadk.core.util.x.t(arrayList)) {
                    this.bzl.byg.Xz();
                } else if (coVar.hasMore) {
                    this.bzl.byg.Xy();
                } else if (coVar.bBT) {
                    this.bzl.byg.Jh();
                } else {
                    this.bzl.byg.Xz();
                }
            }
        } else {
            coVar = new co();
            coVar.pn = 1;
            coVar.hasMore = false;
            coVar.bBT = false;
        }
        if (i == 1) {
            this.bzl.byq = true;
            this.bzl.byW.a(this.bzl.byr.getType(), false, aVar);
        } else {
            this.bzl.a(aVar, true);
            if (this.bzl.byr.ZZ() != null) {
                this.bzl.byh = this.bzl.byr.ZZ();
            }
            this.bzl.Wy();
        }
        ceVar = this.bzl.bzk;
        if (ceVar == null) {
            return;
        }
        ceVar2 = this.bzl.bzk;
        ceVar2.a(i, i2, coVar, arrayList);
    }
}
