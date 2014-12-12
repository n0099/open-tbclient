package com.baidu.tbadk.coreExtra.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements TextWatcher {
    final /* synthetic */ SearchBar UR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(SearchBar searchBar) {
        this.UR = searchBar;
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
        if (this.UR.getSearchText().length() > 0) {
            imageView2 = this.UR.UM;
            imageView2.setVisibility(0);
        } else {
            imageView = this.UR.UM;
            imageView.setVisibility(8);
        }
        auVar = this.UR.UQ;
        if (auVar != null) {
            auVar2 = this.UR.UQ;
            auVar2.dJ(this.UR.getSearchText());
        }
    }
}
