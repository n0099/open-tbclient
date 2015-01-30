package com.baidu.tbadk.coreExtra.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements TextWatcher {
    final /* synthetic */ SearchBar Vw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(SearchBar searchBar) {
        this.Vw = searchBar;
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
        au auVar;
        au auVar2;
        ImageView imageView2;
        if (this.Vw.getSearchText().length() > 0) {
            imageView2 = this.Vw.Vs;
            imageView2.setVisibility(0);
        } else {
            imageView = this.Vw.Vs;
            imageView.setVisibility(8);
        }
        auVar = this.Vw.Vv;
        if (auVar != null) {
            auVar2 = this.Vw.Vv;
            auVar2.dI(this.Vw.getSearchText());
        }
    }
}
