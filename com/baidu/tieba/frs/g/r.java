package com.baidu.tieba.frs.g;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements q.a {
    final /* synthetic */ i cbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(i iVar) {
        this.cbv = iVar;
    }

    @Override // com.baidu.tieba.frs.view.q.a
    public void iD(int i) {
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
                frsActivity10 = this.cbv.bOf;
                com.baidu.tieba.tbadkCore.n Zr = frsActivity10.Zr();
                frsActivity11 = this.cbv.bOf;
                TbPageContext pageContext = frsActivity11.getPageContext();
                frsActivity12 = this.cbv.bOf;
                com.baidu.tieba.frs.f.u.b(Zr, pageContext, frsActivity12.YT());
                return;
            case 1:
                frsActivity7 = this.cbv.bOf;
                com.baidu.tieba.tbadkCore.n Zr2 = frsActivity7.Zr();
                frsActivity8 = this.cbv.bOf;
                TbPageContext pageContext2 = frsActivity8.getPageContext();
                frsActivity9 = this.cbv.bOf;
                com.baidu.tieba.frs.f.u.a(Zr2, pageContext2, frsActivity9.YT());
                return;
            case 2:
                frsActivity5 = this.cbv.bOf;
                com.baidu.tieba.tbadkCore.n Zr3 = frsActivity5.Zr();
                frsActivity6 = this.cbv.bOf;
                com.baidu.tieba.frs.f.u.b(Zr3, frsActivity6.getPageContext());
                return;
            case 3:
                frsActivity3 = this.cbv.bOf;
                com.baidu.tieba.tbadkCore.n Zr4 = frsActivity3.Zr();
                frsActivity4 = this.cbv.bOf;
                com.baidu.tieba.frs.f.u.c(Zr4, frsActivity4.getPageContext());
                return;
            case 4:
            default:
                return;
            case 5:
                frsActivity = this.cbv.bOf;
                com.baidu.tieba.tbadkCore.n Zr5 = frsActivity.Zr();
                frsActivity2 = this.cbv.bOf;
                com.baidu.tieba.frs.f.u.a(Zr5, frsActivity2.getPageContext());
                return;
        }
    }
}
