package com.baidu.tieba.frs.h;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements q.a {
    final /* synthetic */ i bPb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.bPb = iVar;
    }

    @Override // com.baidu.tieba.frs.view.q.a
    public void hT(int i) {
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
                frsActivity8 = this.bPb.bzH;
                com.baidu.tieba.tbadkCore.o WF = frsActivity8.WF();
                frsActivity9 = this.bPb.bzH;
                TbPageContext pageContext = frsActivity9.getPageContext();
                frsActivity10 = this.bPb.bzH;
                com.baidu.tieba.frs.utils.u.b(WF, pageContext, frsActivity10.Wh());
                return;
            case 1:
                frsActivity5 = this.bPb.bzH;
                com.baidu.tieba.tbadkCore.o WF2 = frsActivity5.WF();
                frsActivity6 = this.bPb.bzH;
                TbPageContext pageContext2 = frsActivity6.getPageContext();
                frsActivity7 = this.bPb.bzH;
                com.baidu.tieba.frs.utils.u.a(WF2, pageContext2, frsActivity7.Wh());
                return;
            case 2:
                frsActivity3 = this.bPb.bzH;
                com.baidu.tieba.tbadkCore.o WF3 = frsActivity3.WF();
                frsActivity4 = this.bPb.bzH;
                com.baidu.tieba.frs.utils.u.a(WF3, frsActivity4.getPageContext());
                return;
            case 3:
                frsActivity = this.bPb.bzH;
                com.baidu.tieba.tbadkCore.o WF4 = frsActivity.WF();
                frsActivity2 = this.bPb.bzH;
                com.baidu.tieba.frs.utils.u.b(WF4, frsActivity2.getPageContext());
                return;
            default:
                return;
        }
    }
}
