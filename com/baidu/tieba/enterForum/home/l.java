package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tieba.enterForum.c.h {
    final /* synthetic */ a aFe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.aFe = aVar;
    }

    @Override // com.baidu.tieba.enterForum.c.h
    public void a(com.baidu.tieba.enterForum.c.g gVar) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        long j;
        long j2;
        com.baidu.tieba.enterForum.c.c cVar;
        long j3;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        com.baidu.tieba.enterForum.c.c cVar4;
        boolean isShow;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar5;
        com.baidu.tieba.enterForum.d.e eVar;
        com.baidu.tieba.enterForum.d.e eVar2;
        if (this.aFe.isAdded()) {
            baseFragmentActivity = this.aFe.azl;
            if (UtilHelper.getNetStatusInfo(baseFragmentActivity.getPageContext().getPageActivity()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
                eVar2 = this.aFe.aEM;
                eVar2.ID();
            }
            this.aFe.e(true, "");
            if (gVar.type == 1) {
                eVar = this.aFe.aEM;
                eVar.Iy();
            }
            if (gVar.aFC) {
                if (gVar.type == 1) {
                    this.aFe.aEO = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.aFe.a(gVar.aFD);
                } else if (gVar.type == 0) {
                    z = this.aFe.aEO;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = gVar.aFD;
                        cVar5 = this.aFe.aEN;
                        cVar5.b(bVar);
                        this.aFe.a(bVar);
                    }
                }
            } else if (gVar.aFB != null && !gVar.aFB.equals("")) {
                baseFragmentActivity2 = this.aFe.azl;
                baseFragmentActivity2.showToast(gVar.aFB);
            }
            if (gVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
                isShow = this.aFe.isShow();
                if (isShow) {
                    TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
                }
            }
            if (gVar.type == 1) {
                j = this.aFe.aEQ;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.aFe.aEQ;
                    cVar = this.aFe.aEN;
                    long Id = cVar.Id();
                    j3 = this.aFe.aEQ;
                    long j4 = Id - j3;
                    cVar2 = this.aFe.aEN;
                    long Ib = cVar2.Ib();
                    cVar3 = this.aFe.aEN;
                    long Ic = cVar3.Ic();
                    cVar4 = this.aFe.aEN;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Ib, Ic, currentTimeMillis - cVar4.Ia());
                    this.aFe.aEQ = -1L;
                }
            }
            com.baidu.tieba.enterForum.b.b bVar2 = gVar.aFD;
            if (bVar2.Hz() == 1) {
                if (!bVar2.HG()) {
                    baseFragmentActivity3 = this.aFe.azl;
                    String.format(baseFragmentActivity3.getPageContext().getPageActivity().getString(t.signallforum_warning), Integer.valueOf(bVar2.HA()));
                    return;
                }
                return;
            }
            bVar2.HB();
        }
    }
}
