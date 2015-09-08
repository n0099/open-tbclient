package com.baidu.tbadk.coreExtra.view;

import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.baidu.tbadk.coreExtra.view.LabelViewContainer;
/* loaded from: classes.dex */
class o implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ LabelViewContainer alZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LabelViewContainer labelViewContainer) {
        this.alZ = labelViewContainer;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        LabelViewContainer.a aVar;
        LabelViewContainer.a aVar2;
        RelativeLayout relativeLayout;
        aVar = this.alZ.alL;
        if (aVar != null) {
            aVar2 = this.alZ.alL;
            relativeLayout = this.alZ.alM;
            aVar2.showAddHotIconCallback(relativeLayout);
        }
    }
}
