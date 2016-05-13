package com.baidu.tieba.frs.h;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements x.a {
    final /* synthetic */ e bup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.bup = eVar;
    }

    @Override // com.baidu.tieba.frs.view.x.a
    public void gk(int i) {
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
                frsActivity10 = this.bup.bjB;
                com.baidu.tieba.tbadkCore.o PZ = frsActivity10.PZ();
                frsActivity11 = this.bup.bjB;
                TbPageContext pageContext = frsActivity11.getPageContext();
                frsActivity12 = this.bup.bjB;
                com.baidu.tieba.frs.utils.b.b(PZ, pageContext, frsActivity12.Qd());
                return;
            case 1:
                frsActivity7 = this.bup.bjB;
                com.baidu.tieba.tbadkCore.o PZ2 = frsActivity7.PZ();
                frsActivity8 = this.bup.bjB;
                TbPageContext pageContext2 = frsActivity8.getPageContext();
                frsActivity9 = this.bup.bjB;
                com.baidu.tieba.frs.utils.b.a(PZ2, pageContext2, frsActivity9.Qd());
                return;
            case 2:
                frsActivity5 = this.bup.bjB;
                com.baidu.tieba.tbadkCore.o PZ3 = frsActivity5.PZ();
                frsActivity6 = this.bup.bjB;
                com.baidu.tieba.frs.utils.b.a(PZ3, frsActivity6.getPageContext());
                return;
            case 3:
                frsActivity3 = this.bup.bjB;
                com.baidu.tieba.tbadkCore.o PZ4 = frsActivity3.PZ();
                frsActivity4 = this.bup.bjB;
                com.baidu.tieba.frs.utils.b.a(PZ4, frsActivity4.getPageContext());
                return;
            case 4:
                frsActivity = this.bup.bjB;
                com.baidu.tieba.tbadkCore.o PZ5 = frsActivity.PZ();
                frsActivity2 = this.bup.bjB;
                com.baidu.tieba.frs.utils.b.a(PZ5, frsActivity2.getPageContext());
                return;
            default:
                return;
        }
    }
}
