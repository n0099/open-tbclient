package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* loaded from: classes.dex */
class at implements View.OnClickListener {
    final /* synthetic */ SearchBar Vw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(SearchBar searchBar) {
        this.Vw = searchBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Vw.setSearchText("");
    }
}
