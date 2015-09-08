package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements c.b {
    final /* synthetic */ d aMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(d dVar) {
        this.aMQ = dVar;
    }

    @Override // com.baidu.tieba.enterForum.c.c.b
    public void a(c.a aVar) {
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
        if (this.aMQ.isAdded()) {
            if (!com.baidu.adp.lib.util.i.iL()) {
                this.aMQ.aMz.Je();
            }
            this.aMQ.d(true, "");
            if (aVar.type == 1) {
                this.aMQ.aMz.IZ();
            }
            if (aVar.aNo) {
                if (aVar.type == 1) {
                    this.aMQ.aMB = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.aMQ.a(aVar.aNp);
                } else if (aVar.type == 0) {
                    z = this.aMQ.aMB;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.aNp;
                        cVar5 = this.aMQ.aMA;
                        cVar5.b(bVar);
                        this.aMQ.a(bVar);
                    }
                }
            } else if (aVar.aNn != null && !aVar.aNn.equals("")) {
                this.aMQ.aGQ.showToast(aVar.aNn);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
                isShow = this.aMQ.isShow();
                if (isShow) {
                    TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.aMQ.aMD;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.aMQ.aMD;
                    cVar = this.aMQ.aMA;
                    long IE = cVar.IE();
                    j3 = this.aMQ.aMD;
                    long j4 = IE - j3;
                    cVar2 = this.aMQ.aMA;
                    long IC = cVar2.IC();
                    cVar3 = this.aMQ.aMA;
                    long ID = cVar3.ID();
                    cVar4 = this.aMQ.aMA;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, IC, ID, currentTimeMillis - cVar4.IB());
                    this.aMQ.aMD = -1L;
                }
            }
        }
    }
}
