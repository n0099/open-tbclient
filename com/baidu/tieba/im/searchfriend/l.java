package com.baidu.tieba.im.searchfriend;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements TextWatcher {
    final /* synthetic */ j bmI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.bmI = jVar;
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
            imageView2 = this.bmI.bmF;
            imageView2.setVisibility(8);
            return;
        }
        imageView = this.bmI.bmF;
        imageView.setVisibility(0);
    }
}
