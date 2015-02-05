package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ ah arf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ah ahVar) {
        this.arf = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.a aVar;
        n nVar;
        n nVar2;
        com.baidu.tieba.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.arf.arb;
        nVar = this.arf.apE;
        List<a> BK = nVar.BK();
        nVar2 = this.arf.apE;
        aVar.a(BK, nVar2.BI());
        aVar2 = this.arf.arb;
        navigationBar = this.arf.mNavigationBar;
        aVar2.J(navigationBar);
    }
}
