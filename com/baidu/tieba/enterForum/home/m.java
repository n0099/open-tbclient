package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.enterForum.c.h {
    final /* synthetic */ a aCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.aCT = aVar;
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
        baseFragmentActivity = this.aCT.aCF;
        if (UtilHelper.getNetStatusInfo(baseFragmentActivity.getPageContext().getPageActivity()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            eVar2 = this.aCT.aCB;
            eVar2.Hw();
        }
        this.aCT.e(true, "");
        BdLog.d("OnLoadForumDataCallback, eventArgs.isOk=" + gVar.aDr);
        if (gVar.type == 1) {
            eVar = this.aCT.aCB;
            eVar.Hr();
        }
        if (gVar.aDr) {
            if (gVar.type == 1) {
                this.aCT.aCD = true;
                new com.baidu.tieba.enterForum.b.b();
                this.aCT.a(gVar.aDs);
            } else if (gVar.type == 0) {
                z = this.aCT.aCD;
                if (!z) {
                    new com.baidu.tieba.enterForum.b.b();
                    com.baidu.tieba.enterForum.b.b bVar = gVar.aDs;
                    cVar5 = this.aCT.aCC;
                    cVar5.b(bVar);
                    this.aCT.a(bVar);
                }
            }
        } else if (gVar.aDq != null && !gVar.aDq.equals("")) {
            baseFragmentActivity2 = this.aCT.aCF;
            baseFragmentActivity2.showToast(gVar.aDq);
        }
        if (gVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
            isShow = this.aCT.isShow();
            if (isShow) {
                TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
            }
        }
        if (gVar.type == 1) {
            j = this.aCT.aCG;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.aCT.aCG;
                cVar = this.aCT.aCC;
                long GU = cVar.GU();
                j3 = this.aCT.aCG;
                long j4 = GU - j3;
                cVar2 = this.aCT.aCC;
                long GS = cVar2.GS();
                cVar3 = this.aCT.aCC;
                long GT = cVar3.GT();
                cVar4 = this.aCT.aCC;
                TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, GS, GT, currentTimeMillis - cVar4.GR());
                this.aCT.aCG = -1L;
            }
        }
        com.baidu.tieba.enterForum.b.b bVar2 = gVar.aDs;
        if (bVar2.Go() == 1) {
            if (!bVar2.Gv()) {
                baseFragmentActivity3 = this.aCT.aCF;
                String.format(baseFragmentActivity3.getPageContext().getPageActivity().getString(y.signallforum_warning), Integer.valueOf(bVar2.Gp()));
                return;
            }
            return;
        }
        bVar2.Gq();
    }
}
