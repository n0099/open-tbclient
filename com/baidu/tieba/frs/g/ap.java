package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements Runnable {
    final /* synthetic */ ao cbZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.cbZ = aoVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        cp cpVar;
        cp cpVar2;
        View.OnClickListener onClickListener;
        cp cpVar3;
        BdSwitchView.a aVar;
        boolean z;
        boolean z2;
        boolean z3;
        cp cpVar4;
        FrsActivity frsActivity;
        cpVar = this.cbZ.cbT;
        cpVar.aaF();
        cpVar2 = this.cbZ.cbT;
        onClickListener = this.cbZ.bNB;
        cpVar2.setCommonClickListener(onClickListener);
        cpVar3 = this.cbZ.cbT;
        aVar = this.cbZ.cbY;
        cpVar3.b(aVar);
        ao aoVar = this.cbZ;
        z = this.cbZ.cbW;
        aoVar.em(z);
        ao aoVar2 = this.cbZ;
        z2 = this.cbZ.cbU;
        aoVar2.dR(z2);
        ao aoVar3 = this.cbZ;
        z3 = this.cbZ.cbV;
        aoVar3.dQ(z3);
        cpVar4 = this.cbZ.cbT;
        frsActivity = this.cbZ.bST;
        cpVar4.c(frsActivity.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }
}
