package com.baidu.tieba.frs.i;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements p.a {
    final /* synthetic */ h bSd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(h hVar) {
        this.bSd = hVar;
    }

    @Override // com.baidu.tieba.frs.view.p.a
    public void hU(int i) {
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
                frsActivity10 = this.bSd.bET;
                com.baidu.tieba.tbadkCore.p VC = frsActivity10.VC();
                frsActivity11 = this.bSd.bET;
                TbPageContext pageContext = frsActivity11.getPageContext();
                frsActivity12 = this.bSd.bET;
                com.baidu.tieba.frs.utils.b.b(VC, pageContext, frsActivity12.VG());
                return;
            case 1:
                frsActivity7 = this.bSd.bET;
                com.baidu.tieba.tbadkCore.p VC2 = frsActivity7.VC();
                frsActivity8 = this.bSd.bET;
                TbPageContext pageContext2 = frsActivity8.getPageContext();
                frsActivity9 = this.bSd.bET;
                com.baidu.tieba.frs.utils.b.a(VC2, pageContext2, frsActivity9.VG());
                return;
            case 2:
                frsActivity5 = this.bSd.bET;
                com.baidu.tieba.tbadkCore.p VC3 = frsActivity5.VC();
                frsActivity6 = this.bSd.bET;
                com.baidu.tieba.frs.utils.b.a(VC3, frsActivity6.getPageContext());
                return;
            case 3:
                frsActivity3 = this.bSd.bET;
                com.baidu.tieba.tbadkCore.p VC4 = frsActivity3.VC();
                frsActivity4 = this.bSd.bET;
                com.baidu.tieba.frs.utils.b.a(VC4, frsActivity4.getPageContext());
                return;
            case 4:
                frsActivity = this.bSd.bET;
                com.baidu.tieba.tbadkCore.p VC5 = frsActivity.VC();
                frsActivity2 = this.bSd.bET;
                com.baidu.tieba.frs.utils.b.a(VC5, frsActivity2.getPageContext());
                return;
            default:
                return;
        }
    }
}
