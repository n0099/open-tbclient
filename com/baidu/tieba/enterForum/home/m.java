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
    final /* synthetic */ a aDb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.aDb = aVar;
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
        baseFragmentActivity = this.aDb.aCN;
        if (UtilHelper.getNetStatusInfo(baseFragmentActivity.getPageContext().getPageActivity()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            eVar2 = this.aDb.aCJ;
            eVar2.HC();
        }
        this.aDb.e(true, "");
        BdLog.d("OnLoadForumDataCallback, eventArgs.isOk=" + gVar.aDz);
        if (gVar.type == 1) {
            eVar = this.aDb.aCJ;
            eVar.Hx();
        }
        if (gVar.aDz) {
            if (gVar.type == 1) {
                this.aDb.aCL = true;
                new com.baidu.tieba.enterForum.b.b();
                this.aDb.a(gVar.aDA);
            } else if (gVar.type == 0) {
                z = this.aDb.aCL;
                if (!z) {
                    new com.baidu.tieba.enterForum.b.b();
                    com.baidu.tieba.enterForum.b.b bVar = gVar.aDA;
                    cVar5 = this.aDb.aCK;
                    cVar5.b(bVar);
                    this.aDb.a(bVar);
                }
            }
        } else if (gVar.aDy != null && !gVar.aDy.equals("")) {
            baseFragmentActivity2 = this.aDb.aCN;
            baseFragmentActivity2.showToast(gVar.aDy);
        }
        if (gVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
            isShow = this.aDb.isShow();
            if (isShow) {
                TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
            }
        }
        if (gVar.type == 1) {
            j = this.aDb.aCO;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.aDb.aCO;
                cVar = this.aDb.aCK;
                long Ha = cVar.Ha();
                j3 = this.aDb.aCO;
                long j4 = Ha - j3;
                cVar2 = this.aDb.aCK;
                long GY = cVar2.GY();
                cVar3 = this.aDb.aCK;
                long GZ = cVar3.GZ();
                cVar4 = this.aDb.aCK;
                TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, GY, GZ, currentTimeMillis - cVar4.GX());
                this.aDb.aCO = -1L;
            }
        }
        com.baidu.tieba.enterForum.b.b bVar2 = gVar.aDA;
        if (bVar2.Gu() == 1) {
            if (!bVar2.GB()) {
                baseFragmentActivity3 = this.aDb.aCN;
                String.format(baseFragmentActivity3.getPageContext().getPageActivity().getString(y.signallforum_warning), Integer.valueOf(bVar2.Gv()));
                return;
            }
            return;
        }
        bVar2.Gw();
    }
}
