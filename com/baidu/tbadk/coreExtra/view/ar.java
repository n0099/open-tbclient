package com.baidu.tbadk.coreExtra.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements TextWatcher {
    final /* synthetic */ SearchBar Pf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SearchBar searchBar) {
        this.Pf = searchBar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        ImageView imageView;
        at atVar;
        at atVar2;
        ImageView imageView2;
        if (this.Pf.getSearchText().length() > 0) {
            imageView2 = this.Pf.Pb;
            imageView2.setVisibility(0);
        } else {
            imageView = this.Pf.Pb;
            imageView.setVisibility(8);
        }
        atVar = this.Pf.Pe;
        if (atVar != null) {
            atVar2 = this.Pf.Pe;
            atVar2.cN(this.Pf.getSearchText());
        }
    }
}
