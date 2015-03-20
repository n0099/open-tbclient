package com.baidu.tieba.addresslist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ AddressListActivity axr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AddressListActivity addressListActivity) {
        this.axr = addressListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.axr.closeActivity();
    }
}
