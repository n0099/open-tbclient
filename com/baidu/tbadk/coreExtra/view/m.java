package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l alp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.alp = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.alp.zc();
        this.alp.za();
    }
}
