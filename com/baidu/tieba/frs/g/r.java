package com.baidu.tieba.frs.g;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements q.a {
    final /* synthetic */ i cdM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(i iVar) {
        this.cdM = iVar;
    }

    @Override // com.baidu.tieba.frs.view.q.a
    public void iJ(int i) {
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
                frsActivity10 = this.cdM.bQw;
                com.baidu.tieba.tbadkCore.n aas = frsActivity10.aas();
                frsActivity11 = this.cdM.bQw;
                TbPageContext pageContext = frsActivity11.getPageContext();
                frsActivity12 = this.cdM.bQw;
                com.baidu.tieba.frs.f.u.b(aas, pageContext, frsActivity12.ZU());
                return;
            case 1:
                frsActivity7 = this.cdM.bQw;
                com.baidu.tieba.tbadkCore.n aas2 = frsActivity7.aas();
                frsActivity8 = this.cdM.bQw;
                TbPageContext pageContext2 = frsActivity8.getPageContext();
                frsActivity9 = this.cdM.bQw;
                com.baidu.tieba.frs.f.u.a(aas2, pageContext2, frsActivity9.ZU());
                return;
            case 2:
                frsActivity5 = this.cdM.bQw;
                com.baidu.tieba.tbadkCore.n aas3 = frsActivity5.aas();
                frsActivity6 = this.cdM.bQw;
                com.baidu.tieba.frs.f.u.b(aas3, frsActivity6.getPageContext());
                return;
            case 3:
                frsActivity3 = this.cdM.bQw;
                com.baidu.tieba.tbadkCore.n aas4 = frsActivity3.aas();
                frsActivity4 = this.cdM.bQw;
                com.baidu.tieba.frs.f.u.c(aas4, frsActivity4.getPageContext());
                return;
            case 4:
            default:
                return;
            case 5:
                frsActivity = this.cdM.bQw;
                com.baidu.tieba.tbadkCore.n aas5 = frsActivity.aas();
                frsActivity2 = this.cdM.bQw;
                com.baidu.tieba.frs.f.u.a(aas5, frsActivity2.getPageContext());
                return;
        }
    }
}
