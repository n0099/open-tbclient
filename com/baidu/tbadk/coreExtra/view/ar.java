package com.baidu.tbadk.coreExtra.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements TextWatcher {
    final /* synthetic */ SearchBar Pb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SearchBar searchBar) {
        this.Pb = searchBar;
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
        if (this.Pb.getSearchText().length() > 0) {
            imageView2 = this.Pb.OX;
            imageView2.setVisibility(0);
        } else {
            imageView = this.Pb.OX;
            imageView.setVisibility(8);
        }
        atVar = this.Pb.Pa;
        if (atVar != null) {
            atVar2 = this.Pb.Pa;
            atVar2.cN(this.Pb.getSearchText());
        }
    }
}
