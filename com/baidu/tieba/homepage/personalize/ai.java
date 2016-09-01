package com.baidu.tieba.homepage.personalize;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ z cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(z zVar) {
        this.cFs = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        b bVar2;
        bVar = this.cFs.cFn;
        if (bVar != null) {
            bVar2 = this.cFs.cFn;
            bVar2.update();
        }
    }
}
