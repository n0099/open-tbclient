package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* loaded from: classes.dex */
class at implements View.OnClickListener {
    final /* synthetic */ SearchBar Vt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(SearchBar searchBar) {
        this.Vt = searchBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Vt.setSearchText("");
    }
}
