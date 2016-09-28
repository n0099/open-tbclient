package com.baidu.tieba.frs.i;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements p.a {
    final /* synthetic */ h cfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(h hVar) {
        this.cfi = hVar;
    }

    @Override // com.baidu.tieba.frs.view.p.a
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
        switch (i) {
            case 0:
                frsActivity8 = this.cfi.bRi;
                com.baidu.tieba.tbadkCore.p abe = frsActivity8.abe();
                frsActivity9 = this.cfi.bRi;
                TbPageContext pageContext = frsActivity9.getPageContext();
                frsActivity10 = this.cfi.bRi;
                com.baidu.tieba.frs.utils.b.b(abe, pageContext, frsActivity10.abi());
                return;
            case 1:
                frsActivity5 = this.cfi.bRi;
                com.baidu.tieba.tbadkCore.p abe2 = frsActivity5.abe();
                frsActivity6 = this.cfi.bRi;
                TbPageContext pageContext2 = frsActivity6.getPageContext();
                frsActivity7 = this.cfi.bRi;
                com.baidu.tieba.frs.utils.b.a(abe2, pageContext2, frsActivity7.abi());
                return;
            case 2:
                frsActivity3 = this.cfi.bRi;
                com.baidu.tieba.tbadkCore.p abe3 = frsActivity3.abe();
                frsActivity4 = this.cfi.bRi;
                com.baidu.tieba.frs.utils.b.a(abe3, frsActivity4.getPageContext());
                return;
            case 3:
                frsActivity = this.cfi.bRi;
                com.baidu.tieba.tbadkCore.p abe4 = frsActivity.abe();
                frsActivity2 = this.cfi.bRi;
                com.baidu.tieba.frs.utils.b.a(abe4, frsActivity2.getPageContext());
                return;
            default:
                return;
        }
    }
}
