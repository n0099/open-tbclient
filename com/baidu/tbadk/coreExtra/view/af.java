package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af implements View.OnClickListener {
    final /* synthetic */ SearchBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SearchBar searchBar) {
        this.a = searchBar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ag agVar;
        ag agVar2;
        agVar = this.a.e;
        if (agVar != null) {
            agVar2 = this.a.e;
            agVar2.b(this.a.getSearchText());
        }
    }
}
