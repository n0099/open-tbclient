package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ am bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.bWd = amVar;
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
        cnVar = this.bWd.bVX;
        cnVar.Zi();
        cnVar2 = this.bWd.bVX;
        onClickListener = this.bWd.bGD;
        cnVar2.setCommonClickListener(onClickListener);
        cnVar3 = this.bWd.bVX;
        aVar = this.bWd.bWc;
        cnVar3.b(aVar);
        am amVar = this.bWd;
        z = this.bWd.bWa;
        amVar.em(z);
        am amVar2 = this.bWd;
        z2 = this.bWd.bVY;
        amVar2.dP(z2);
        am amVar3 = this.bWd;
        z3 = this.bWd.bVZ;
        amVar3.dO(z3);
        cnVar4 = this.bWd.bVX;
        frsActivity = this.bWd.bLZ;
        cnVar4.c(frsActivity.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }
}
