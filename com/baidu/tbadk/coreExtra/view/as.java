package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* loaded from: classes.dex */
class as implements View.OnClickListener {
    final /* synthetic */ SearchBar Pf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(SearchBar searchBar) {
        this.Pf = searchBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Pf.setSearchText("");
    }
}
