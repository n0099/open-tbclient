package com.baidu.tieba.addresslist;

import android.view.View;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ AddressListActivity ayS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AddressListActivity addressListActivity) {
        this.ayS = addressListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ayS.finish();
    }
}
