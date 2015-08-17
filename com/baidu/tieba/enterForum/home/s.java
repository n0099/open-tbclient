package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements c.b {
    final /* synthetic */ d aMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(d dVar) {
        this.aMD = dVar;
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
        if (this.aMD.isAdded()) {
            if (!com.baidu.adp.lib.util.i.iO()) {
                this.aMD.aMm.Jq();
            }
            this.aMD.e(true, "");
            if (aVar.type == 1) {
                this.aMD.aMm.Jl();
            }
            if (aVar.aNb) {
                if (aVar.type == 1) {
                    this.aMD.aMo = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.aMD.a(aVar.aNc);
                } else if (aVar.type == 0) {
                    z = this.aMD.aMo;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.aNc;
                        cVar5 = this.aMD.aMn;
                        cVar5.b(bVar);
                        this.aMD.a(bVar);
                    }
                }
            } else if (aVar.aNa != null && !aVar.aNa.equals("")) {
                this.aMD.aGD.showToast(aVar.aNa);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
                isShow = this.aMD.isShow();
                if (isShow) {
                    TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.aMD.aMq;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.aMD.aMq;
                    cVar = this.aMD.aMn;
                    long IQ = cVar.IQ();
                    j3 = this.aMD.aMq;
                    long j4 = IQ - j3;
                    cVar2 = this.aMD.aMn;
                    long IO = cVar2.IO();
                    cVar3 = this.aMD.aMn;
                    long IP = cVar3.IP();
                    cVar4 = this.aMD.aMn;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, IO, IP, currentTimeMillis - cVar4.IN());
                    this.aMD.aMq = -1L;
                }
            }
        }
    }
}
