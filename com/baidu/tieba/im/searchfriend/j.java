package com.baidu.tieba.im.searchfriend;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements TextWatcher {
    final /* synthetic */ h bih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bih = hVar;
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
            imageView2 = this.bih.bic;
            imageView2.setVisibility(8);
            return;
        }
        imageView = this.bih.bic;
        imageView.setVisibility(0);
    }
}
