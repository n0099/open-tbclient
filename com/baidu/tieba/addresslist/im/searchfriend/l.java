package com.baidu.tieba.addresslist.im.searchfriend;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements TextWatcher {
    final /* synthetic */ j aAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aAW = jVar;
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
        ImageView imageView2;
        if (TextUtils.isEmpty(editable)) {
            imageView2 = this.aAW.aAT;
            imageView2.setVisibility(8);
            return;
        }
        imageView = this.aAW.aAT;
        imageView.setVisibility(0);
    }
}
