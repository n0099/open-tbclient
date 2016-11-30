package com.baidu.tieba.frs.j;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements q.a {
    final /* synthetic */ f cjT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.cjT = fVar;
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
        switch (i) {
            case 0:
                frsActivity8 = this.cjT.bTA;
                com.baidu.tieba.tbadkCore.p acr = frsActivity8.acr();
                frsActivity9 = this.cjT.bTA;
                TbPageContext pageContext = frsActivity9.getPageContext();
                frsActivity10 = this.cjT.bTA;
                com.baidu.tieba.frs.utils.w.b(acr, pageContext, frsActivity10.abS());
                return;
            case 1:
                frsActivity5 = this.cjT.bTA;
                com.baidu.tieba.tbadkCore.p acr2 = frsActivity5.acr();
                frsActivity6 = this.cjT.bTA;
                TbPageContext pageContext2 = frsActivity6.getPageContext();
                frsActivity7 = this.cjT.bTA;
                com.baidu.tieba.frs.utils.w.a(acr2, pageContext2, frsActivity7.abS());
                return;
            case 2:
                frsActivity3 = this.cjT.bTA;
                com.baidu.tieba.tbadkCore.p acr3 = frsActivity3.acr();
                frsActivity4 = this.cjT.bTA;
                com.baidu.tieba.frs.utils.w.a(acr3, frsActivity4.getPageContext());
                return;
            case 3:
                frsActivity = this.cjT.bTA;
                com.baidu.tieba.tbadkCore.p acr4 = frsActivity.acr();
                frsActivity2 = this.cjT.bTA;
                com.baidu.tieba.frs.utils.w.a(acr4, frsActivity2.getPageContext());
                return;
            default:
                return;
        }
    }
}
