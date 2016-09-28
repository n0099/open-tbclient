package com.baidu.tieba.homepage.personalize;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ a cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.cFs = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        m mVar2;
        mVar = this.cFs.cFm;
        if (mVar != null) {
            mVar2 = this.cFs.cFm;
            mVar2.update();
        }
    }
}
