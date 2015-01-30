package com.baidu.tieba.home;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.model.h {
    final /* synthetic */ f aPP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.aPP = fVar;
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
        baseFragmentActivity = this.aPP.aPI;
        if (UtilHelper.getNetStatusInfo(baseFragmentActivity.getPageContext().getPageActivity()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            rVar8 = this.aPP.aPB;
            rVar8.JN();
        }
        rVar = this.aPP.aPB;
        rVar.h(true, "");
        if (gVar.type == 1) {
            rVar7 = this.aPP.aPB;
            rVar7.JI();
        }
        if (gVar.azu) {
            if (gVar.type == 1) {
                this.aPP.aPG = true;
                new com.baidu.tieba.data.e();
                com.baidu.tieba.data.e eVar = gVar.buu;
                rVar5 = this.aPP.aPB;
                rVar5.b(eVar);
                rVar6 = this.aPP.aPB;
                rVar6.notifyDataSetChanged();
            } else if (gVar.type == 0) {
                z = this.aPP.aPG;
                if (!z) {
                    new com.baidu.tieba.data.e();
                    com.baidu.tieba.data.e eVar2 = gVar.buu;
                    dVar5 = this.aPP.aPD;
                    dVar5.c(eVar2);
                    rVar3 = this.aPP.aPB;
                    rVar3.b(eVar2);
                    rVar4 = this.aPP.aPB;
                    rVar4.notifyDataSetChanged();
                }
            }
        } else if (gVar.but != null && !gVar.but.equals("")) {
            baseFragmentActivity2 = this.aPP.aPI;
            baseFragmentActivity2.showToast(gVar.but);
        }
        if (gVar.type == 1 && TbadkCoreApplication.m255getInst().getIsNewRegUser()) {
            isShow = this.aPP.isShow();
            if (isShow) {
                rVar2 = this.aPP.aPB;
                rVar2.JM();
                TbadkCoreApplication.m255getInst().setIsNewRegUser(false);
            }
        }
        if (gVar.type == 1) {
            j = this.aPP.aDp;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.aPP.aDp;
                dVar = this.aPP.aPD;
                long UA = dVar.UA();
                j3 = this.aPP.aDp;
                long j4 = UA - j3;
                dVar2 = this.aPP.aPD;
                long Uy = dVar2.Uy();
                dVar3 = this.aPP.aPD;
                long Uz = dVar3.Uz();
                dVar4 = this.aPP.aPD;
                TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Uy, Uz, currentTimeMillis - dVar4.Ux());
                this.aPP.aDp = -1L;
            }
        }
    }
}
