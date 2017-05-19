package com.baidu.tieba.frs.e;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.frs.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements k.a {
    final /* synthetic */ i cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(i iVar) {
        this.cbx = iVar;
    }

    @Override // com.baidu.tieba.frs.view.k.a
    public void iB(int i) {
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        com.baidu.tieba.frs.r rVar3;
        com.baidu.tieba.frs.r rVar4;
        com.baidu.tieba.frs.r rVar5;
        com.baidu.tieba.frs.r rVar6;
        com.baidu.tieba.frs.r rVar7;
        switch (i) {
            case 0:
                rVar5 = this.cbx.bPw;
                com.baidu.tieba.tbadkCore.n Zq = rVar5.Zq();
                rVar6 = this.cbx.bPw;
                TbPageContext<BaseFragmentActivity> pageContext = rVar6.getPageContext();
                rVar7 = this.cbx.bPw;
                com.baidu.tieba.frs.d.q.a(Zq, pageContext, rVar7.YU());
                return;
            case 1:
            case 2:
            case 4:
            default:
                return;
            case 3:
                rVar3 = this.cbx.bPw;
                com.baidu.tieba.tbadkCore.n Zq2 = rVar3.Zq();
                rVar4 = this.cbx.bPw;
                com.baidu.tieba.frs.d.q.b(Zq2, rVar4.getPageContext());
                return;
            case 5:
                rVar = this.cbx.bPw;
                com.baidu.tieba.tbadkCore.n Zq3 = rVar.Zq();
                rVar2 = this.cbx.bPw;
                com.baidu.tieba.frs.d.q.a(Zq3, rVar2.getPageContext());
                return;
        }
    }
}
