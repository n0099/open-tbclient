package com.baidu.tieba.frs.f;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements q.a {
    final /* synthetic */ i bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(i iVar) {
        this.bVC = iVar;
    }

    @Override // com.baidu.tieba.frs.view.q.a
    public void iG(int i) {
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
                frsActivity10 = this.bVC.bHh;
                com.baidu.tieba.tbadkCore.n XW = frsActivity10.XW();
                frsActivity11 = this.bVC.bHh;
                TbPageContext pageContext = frsActivity11.getPageContext();
                frsActivity12 = this.bVC.bHh;
                com.baidu.tieba.frs.utils.u.b(XW, pageContext, frsActivity12.Xy());
                return;
            case 1:
                frsActivity7 = this.bVC.bHh;
                com.baidu.tieba.tbadkCore.n XW2 = frsActivity7.XW();
                frsActivity8 = this.bVC.bHh;
                TbPageContext pageContext2 = frsActivity8.getPageContext();
                frsActivity9 = this.bVC.bHh;
                com.baidu.tieba.frs.utils.u.a(XW2, pageContext2, frsActivity9.Xy());
                return;
            case 2:
                frsActivity5 = this.bVC.bHh;
                com.baidu.tieba.tbadkCore.n XW3 = frsActivity5.XW();
                frsActivity6 = this.bVC.bHh;
                com.baidu.tieba.frs.utils.u.b(XW3, frsActivity6.getPageContext());
                return;
            case 3:
                frsActivity3 = this.bVC.bHh;
                com.baidu.tieba.tbadkCore.n XW4 = frsActivity3.XW();
                frsActivity4 = this.bVC.bHh;
                com.baidu.tieba.frs.utils.u.c(XW4, frsActivity4.getPageContext());
                return;
            case 4:
            default:
                return;
            case 5:
                frsActivity = this.bVC.bHh;
                com.baidu.tieba.tbadkCore.n XW5 = frsActivity.XW();
                frsActivity2 = this.bVC.bHh;
                com.baidu.tieba.frs.utils.u.a(XW5, frsActivity2.getPageContext());
                return;
        }
    }
}
