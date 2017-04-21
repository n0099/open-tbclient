package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements Runnable {
    final /* synthetic */ ao ceq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.ceq = aoVar;
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
        cpVar = this.ceq.cek;
        cpVar.abG();
        cpVar2 = this.ceq.cek;
        onClickListener = this.ceq.bPS;
        cpVar2.setCommonClickListener(onClickListener);
        cpVar3 = this.ceq.cek;
        aVar = this.ceq.cep;
        cpVar3.b(aVar);
        ao aoVar = this.ceq;
        z = this.ceq.cen;
        aoVar.ew(z);
        ao aoVar2 = this.ceq;
        z2 = this.ceq.cel;
        aoVar2.eb(z2);
        ao aoVar3 = this.ceq;
        z3 = this.ceq.cem;
        aoVar3.ea(z3);
        cpVar4 = this.ceq.cek;
        frsActivity = this.ceq.bVk;
        cpVar4.c(frsActivity.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }
}
