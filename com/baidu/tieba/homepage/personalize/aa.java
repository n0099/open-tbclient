package com.baidu.tieba.homepage.personalize;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ s crd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(s sVar) {
        this.crd = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        a aVar2;
        aVar = this.crd.cqY;
        if (aVar != null) {
            aVar2 = this.crd.cqY;
            aVar2.update();
        }
    }
}
