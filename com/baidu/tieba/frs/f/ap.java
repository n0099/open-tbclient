package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements Runnable {
    final /* synthetic */ ao cdy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.cdy = aoVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        cn cnVar;
        cn cnVar2;
        View.OnClickListener onClickListener;
        cn cnVar3;
        BdSwitchView.a aVar;
        boolean z;
        boolean z2;
        boolean z3;
        cn cnVar4;
        FrsActivity frsActivity;
        cnVar = this.cdy.cds;
        cnVar.aah();
        cnVar2 = this.cdy.cds;
        onClickListener = this.cdy.bNM;
        cnVar2.setCommonClickListener(onClickListener);
        cnVar3 = this.cdy.cds;
        aVar = this.cdy.cdx;
        cnVar3.b(aVar);
        ao aoVar = this.cdy;
        z = this.cdy.cdv;
        aoVar.em(z);
        ao aoVar2 = this.cdy;
        z2 = this.cdy.cdt;
        aoVar2.dP(z2);
        ao aoVar3 = this.cdy;
        z3 = this.cdy.cdu;
        aoVar3.dO(z3);
        cnVar4 = this.cdy.cds;
        frsActivity = this.cdy.bTf;
        cnVar4.c(frsActivity.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }
}
