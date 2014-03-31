package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* loaded from: classes.dex */
final class ae implements View.OnClickListener {
    final /* synthetic */ SearchBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(SearchBar searchBar) {
        this.a = searchBar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.setSearchText("");
    }
}
