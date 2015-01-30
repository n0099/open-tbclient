package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ ah ari;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ah ahVar) {
        this.ari = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.a aVar;
        n nVar;
        n nVar2;
        com.baidu.tieba.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.ari.are;
        nVar = this.ari.apH;
        List<a> BQ = nVar.BQ();
        nVar2 = this.ari.apH;
        aVar.a(BQ, nVar2.BO());
        aVar2 = this.ari.are;
        navigationBar = this.ari.mNavigationBar;
        aVar2.J(navigationBar);
    }
}
