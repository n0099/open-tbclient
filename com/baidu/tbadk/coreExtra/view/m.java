package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ k amt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.amt = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.amt.zM();
    }
}
