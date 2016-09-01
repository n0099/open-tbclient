package com.baidu.tieba.frs.i;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements p.a {
    final /* synthetic */ h cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(h hVar) {
        this.cfl = hVar;
    }

    @Override // com.baidu.tieba.frs.view.p.a
    public void iy(int i) {
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
                frsActivity10 = this.cfl.bRp;
                com.baidu.tieba.tbadkCore.p aaR = frsActivity10.aaR();
                frsActivity11 = this.cfl.bRp;
                TbPageContext pageContext = frsActivity11.getPageContext();
                frsActivity12 = this.cfl.bRp;
                com.baidu.tieba.frs.utils.b.b(aaR, pageContext, frsActivity12.aaV());
                return;
            case 1:
                frsActivity7 = this.cfl.bRp;
                com.baidu.tieba.tbadkCore.p aaR2 = frsActivity7.aaR();
                frsActivity8 = this.cfl.bRp;
                TbPageContext pageContext2 = frsActivity8.getPageContext();
                frsActivity9 = this.cfl.bRp;
                com.baidu.tieba.frs.utils.b.a(aaR2, pageContext2, frsActivity9.aaV());
                return;
            case 2:
                frsActivity5 = this.cfl.bRp;
                com.baidu.tieba.tbadkCore.p aaR3 = frsActivity5.aaR();
                frsActivity6 = this.cfl.bRp;
                com.baidu.tieba.frs.utils.b.a(aaR3, frsActivity6.getPageContext());
                return;
            case 3:
                frsActivity3 = this.cfl.bRp;
                com.baidu.tieba.tbadkCore.p aaR4 = frsActivity3.aaR();
                frsActivity4 = this.cfl.bRp;
                com.baidu.tieba.frs.utils.b.a(aaR4, frsActivity4.getPageContext());
                return;
            case 4:
                frsActivity = this.cfl.bRp;
                com.baidu.tieba.tbadkCore.p aaR5 = frsActivity.aaR();
                frsActivity2 = this.cfl.bRp;
                com.baidu.tieba.frs.utils.b.a(aaR5, frsActivity2.getPageContext());
                return;
            default:
                return;
        }
    }
}
