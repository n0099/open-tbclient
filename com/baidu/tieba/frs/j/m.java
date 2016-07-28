package com.baidu.tieba.frs.j;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements p.a {
    final /* synthetic */ h bUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(h hVar) {
        this.bUd = hVar;
    }

    @Override // com.baidu.tieba.frs.view.p.a
    public void hV(int i) {
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
                frsActivity10 = this.bUd.bGh;
                com.baidu.tieba.tbadkCore.p VU = frsActivity10.VU();
                frsActivity11 = this.bUd.bGh;
                TbPageContext pageContext = frsActivity11.getPageContext();
                frsActivity12 = this.bUd.bGh;
                com.baidu.tieba.frs.utils.b.b(VU, pageContext, frsActivity12.VY());
                return;
            case 1:
                frsActivity7 = this.bUd.bGh;
                com.baidu.tieba.tbadkCore.p VU2 = frsActivity7.VU();
                frsActivity8 = this.bUd.bGh;
                TbPageContext pageContext2 = frsActivity8.getPageContext();
                frsActivity9 = this.bUd.bGh;
                com.baidu.tieba.frs.utils.b.a(VU2, pageContext2, frsActivity9.VY());
                return;
            case 2:
                frsActivity5 = this.bUd.bGh;
                com.baidu.tieba.tbadkCore.p VU3 = frsActivity5.VU();
                frsActivity6 = this.bUd.bGh;
                com.baidu.tieba.frs.utils.b.a(VU3, frsActivity6.getPageContext());
                return;
            case 3:
                frsActivity3 = this.bUd.bGh;
                com.baidu.tieba.tbadkCore.p VU4 = frsActivity3.VU();
                frsActivity4 = this.bUd.bGh;
                com.baidu.tieba.frs.utils.b.a(VU4, frsActivity4.getPageContext());
                return;
            case 4:
                frsActivity = this.bUd.bGh;
                com.baidu.tieba.tbadkCore.p VU5 = frsActivity.VU();
                frsActivity2 = this.bUd.bGh;
                com.baidu.tieba.frs.utils.b.a(VU5, frsActivity2.getPageContext());
                return;
            default:
                return;
        }
    }
}
