package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* loaded from: classes.dex */
class as implements View.OnClickListener {
    final /* synthetic */ SearchBar Pb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(SearchBar searchBar) {
        this.Pb = searchBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Pb.setSearchText("");
    }
}
