package com.baidu.tieba.frs.f;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements q.a {
    final /* synthetic */ i ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(i iVar) {
        this.ccU = iVar;
    }

    @Override // com.baidu.tieba.frs.view.q.a
    public void iC(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        FrsActivity frsActivity10;
        FrsActivity frsActivity11;
        FrsActivity frsActivity12;
        switch (i) {
            case 0:
                frsActivity10 = this.ccU.bOq;
                com.baidu.tieba.tbadkCore.n YV = frsActivity10.YV();
                frsActivity11 = this.ccU.bOq;
                TbPageContext pageContext = frsActivity11.getPageContext();
                frsActivity12 = this.ccU.bOq;
                com.baidu.tieba.frs.utils.u.b(YV, pageContext, frsActivity12.Yx());
                return;
            case 1:
                frsActivity7 = this.ccU.bOq;
                com.baidu.tieba.tbadkCore.n YV2 = frsActivity7.YV();
                frsActivity8 = this.ccU.bOq;
                TbPageContext pageContext2 = frsActivity8.getPageContext();
                frsActivity9 = this.ccU.bOq;
                com.baidu.tieba.frs.utils.u.a(YV2, pageContext2, frsActivity9.Yx());
                return;
            case 2:
                frsActivity5 = this.ccU.bOq;
                com.baidu.tieba.tbadkCore.n YV3 = frsActivity5.YV();
                frsActivity6 = this.ccU.bOq;
                com.baidu.tieba.frs.utils.u.b(YV3, frsActivity6.getPageContext());
                return;
            case 3:
                frsActivity3 = this.ccU.bOq;
                com.baidu.tieba.tbadkCore.n YV4 = frsActivity3.YV();
                frsActivity4 = this.ccU.bOq;
                com.baidu.tieba.frs.utils.u.c(YV4, frsActivity4.getPageContext());
                return;
            case 4:
            default:
                return;
            case 5:
                frsActivity = this.ccU.bOq;
                com.baidu.tieba.tbadkCore.n YV5 = frsActivity.YV();
                frsActivity2 = this.ccU.bOq;
                com.baidu.tieba.frs.utils.u.a(YV5, frsActivity2.getPageContext());
                return;
        }
    }
}
