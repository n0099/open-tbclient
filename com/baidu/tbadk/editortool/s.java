package com.baidu.tbadk.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView Yg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EmotionTabWidgetView emotionTabWidgetView) {
        this.Yg = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        w wVar2;
        wVar = this.Yg.XD;
        if (wVar != null) {
            wVar2 = this.Yg.XD;
            wVar2.handleAction(21, null);
        }
    }
}
