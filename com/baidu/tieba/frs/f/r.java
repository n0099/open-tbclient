package com.baidu.tieba.frs.f;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.frs.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements k.a {
    final /* synthetic */ i chJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(i iVar) {
        this.chJ = iVar;
    }

    @Override // com.baidu.tieba.frs.view.k.a
    public void iZ(int i) {
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        com.baidu.tieba.frs.r rVar3;
        com.baidu.tieba.frs.r rVar4;
        com.baidu.tieba.frs.r rVar5;
        com.baidu.tieba.frs.r rVar6;
        com.baidu.tieba.frs.r rVar7;
        switch (i) {
            case 0:
                rVar5 = this.chJ.bVm;
                com.baidu.tieba.tbadkCore.n aau = rVar5.aau();
                rVar6 = this.chJ.bVm;
                TbPageContext<BaseFragmentActivity> pageContext = rVar6.getPageContext();
                rVar7 = this.chJ.bVm;
                com.baidu.tieba.frs.e.q.a(aau, pageContext, rVar7.ZY());
                return;
            case 1:
            case 2:
            case 4:
            default:
                return;
            case 3:
                rVar3 = this.chJ.bVm;
                com.baidu.tieba.tbadkCore.n aau2 = rVar3.aau();
                rVar4 = this.chJ.bVm;
                com.baidu.tieba.frs.e.q.b(aau2, rVar4.getPageContext());
                return;
            case 5:
                rVar = this.chJ.bVm;
                com.baidu.tieba.tbadkCore.n aau3 = rVar.aau();
                rVar2 = this.chJ.bVm;
                com.baidu.tieba.frs.e.q.a(aau3, rVar2.getPageContext());
                return;
        }
    }
}
