package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* loaded from: classes.dex */
class at implements View.OnClickListener {
    final /* synthetic */ SearchBar UR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(SearchBar searchBar) {
        this.UR = searchBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.UR.setSearchText("");
    }
}
