package com.baidu.tbadk.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView akg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EmotionTabWidgetView emotionTabWidgetView) {
        this.akg = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v vVar;
        v vVar2;
        vVar = this.akg.ajx;
        if (vVar != null) {
            vVar2 = this.akg.ajx;
            vVar2.handleAction(21, null);
        }
    }
}
