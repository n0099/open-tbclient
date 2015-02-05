package com.baidu.tieba.home;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.model.h {
    final /* synthetic */ f aPO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.aPO = fVar;
    }

    @Override // com.baidu.tieba.model.h
    public void a(com.baidu.tieba.model.g gVar) {
        BaseFragmentActivity baseFragmentActivity;
        r rVar;
        BaseFragmentActivity baseFragmentActivity2;
        long j;
        long j2;
        com.baidu.tieba.model.d dVar;
        long j3;
        com.baidu.tieba.model.d dVar2;
        com.baidu.tieba.model.d dVar3;
        com.baidu.tieba.model.d dVar4;
        boolean isShow;
        r rVar2;
        boolean z;
        com.baidu.tieba.model.d dVar5;
        r rVar3;
        r rVar4;
        r rVar5;
        r rVar6;
        r rVar7;
        r rVar8;
        baseFragmentActivity = this.aPO.aPH;
        if (UtilHelper.getNetStatusInfo(baseFragmentActivity.getPageContext().getPageActivity()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            rVar8 = this.aPO.aPA;
            rVar8.JI();
        }
        rVar = this.aPO.aPA;
        rVar.h(true, "");
        if (gVar.type == 1) {
            rVar7 = this.aPO.aPA;
            rVar7.JD();
        }
        if (gVar.azr) {
            if (gVar.type == 1) {
                this.aPO.aPF = true;
                new com.baidu.tieba.data.e();
                com.baidu.tieba.data.e eVar = gVar.but;
                rVar5 = this.aPO.aPA;
                rVar5.b(eVar);
                rVar6 = this.aPO.aPA;
                rVar6.notifyDataSetChanged();
            } else if (gVar.type == 0) {
                z = this.aPO.aPF;
                if (!z) {
                    new com.baidu.tieba.data.e();
                    com.baidu.tieba.data.e eVar2 = gVar.but;
                    dVar5 = this.aPO.aPC;
                    dVar5.c(eVar2);
                    rVar3 = this.aPO.aPA;
                    rVar3.b(eVar2);
                    rVar4 = this.aPO.aPA;
                    rVar4.notifyDataSetChanged();
                }
            }
        } else if (gVar.bus != null && !gVar.bus.equals("")) {
            baseFragmentActivity2 = this.aPO.aPH;
            baseFragmentActivity2.showToast(gVar.bus);
        }
        if (gVar.type == 1 && TbadkCoreApplication.m255getInst().getIsNewRegUser()) {
            isShow = this.aPO.isShow();
            if (isShow) {
                rVar2 = this.aPO.aPA;
                rVar2.JH();
                TbadkCoreApplication.m255getInst().setIsNewRegUser(false);
            }
        }
        if (gVar.type == 1) {
            j = this.aPO.aDm;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.aPO.aDm;
                dVar = this.aPO.aPC;
                long Uv = dVar.Uv();
                j3 = this.aPO.aDm;
                long j4 = Uv - j3;
                dVar2 = this.aPO.aPC;
                long Ut = dVar2.Ut();
                dVar3 = this.aPO.aPC;
                long Uu = dVar3.Uu();
                dVar4 = this.aPO.aPC;
                TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Ut, Uu, currentTimeMillis - dVar4.Us());
                this.aPO.aDm = -1L;
            }
        }
    }
}
