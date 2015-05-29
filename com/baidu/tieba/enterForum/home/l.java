package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tieba.enterForum.c.h {
    final /* synthetic */ a aFd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.aFd = aVar;
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
        if (this.aFd.isAdded()) {
            baseFragmentActivity = this.aFd.azk;
            if (UtilHelper.getNetStatusInfo(baseFragmentActivity.getPageContext().getPageActivity()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
                eVar2 = this.aFd.aEL;
                eVar2.IC();
            }
            this.aFd.e(true, "");
            if (gVar.type == 1) {
                eVar = this.aFd.aEL;
                eVar.Ix();
            }
            if (gVar.aFB) {
                if (gVar.type == 1) {
                    this.aFd.aEN = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.aFd.a(gVar.aFC);
                } else if (gVar.type == 0) {
                    z = this.aFd.aEN;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = gVar.aFC;
                        cVar5 = this.aFd.aEM;
                        cVar5.b(bVar);
                        this.aFd.a(bVar);
                    }
                }
            } else if (gVar.aFA != null && !gVar.aFA.equals("")) {
                baseFragmentActivity2 = this.aFd.azk;
                baseFragmentActivity2.showToast(gVar.aFA);
            }
            if (gVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
                isShow = this.aFd.isShow();
                if (isShow) {
                    TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
                }
            }
            if (gVar.type == 1) {
                j = this.aFd.aEP;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.aFd.aEP;
                    cVar = this.aFd.aEM;
                    long Ic = cVar.Ic();
                    j3 = this.aFd.aEP;
                    long j4 = Ic - j3;
                    cVar2 = this.aFd.aEM;
                    long Ia = cVar2.Ia();
                    cVar3 = this.aFd.aEM;
                    long Ib = cVar3.Ib();
                    cVar4 = this.aFd.aEM;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Ia, Ib, currentTimeMillis - cVar4.HZ());
                    this.aFd.aEP = -1L;
                }
            }
            com.baidu.tieba.enterForum.b.b bVar2 = gVar.aFC;
            if (bVar2.Hy() == 1) {
                if (!bVar2.HF()) {
                    baseFragmentActivity3 = this.aFd.azk;
                    String.format(baseFragmentActivity3.getPageContext().getPageActivity().getString(t.signallforum_warning), Integer.valueOf(bVar2.Hz()));
                    return;
                }
                return;
            }
            bVar2.HA();
        }
    }
}
