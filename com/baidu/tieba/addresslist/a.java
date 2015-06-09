package com.baidu.tieba.addresslist;

import android.view.View;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ AddressListActivity ayT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AddressListActivity addressListActivity) {
        this.ayT = addressListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ayT.finish();
    }
}
