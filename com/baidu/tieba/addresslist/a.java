package com.baidu.tieba.addresslist;

import android.view.View;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ AddressListActivity aHv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AddressListActivity addressListActivity) {
        this.aHv = addressListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aHv.finish();
    }
}
