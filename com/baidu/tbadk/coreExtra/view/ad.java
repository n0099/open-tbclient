package com.baidu.tbadk.coreExtra.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ad implements TextWatcher {
    final /* synthetic */ SearchBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SearchBar searchBar) {
        this.a = searchBar;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        Button button;
        ag agVar;
        ag agVar2;
        Button button2;
        if (this.a.getSearchText().length() > 0) {
            button2 = this.a.c;
            button2.setVisibility(0);
        } else {
            button = this.a.c;
            button.setVisibility(8);
        }
        agVar = this.a.e;
        if (agVar != null) {
            agVar2 = this.a.e;
            agVar2.a(this.a.getSearchText());
        }
    }
}
