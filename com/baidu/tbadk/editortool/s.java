package com.baidu.tbadk.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView Sk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EmotionTabWidgetView emotionTabWidgetView) {
        this.Sk = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        w wVar2;
        wVar = this.Sk.RG;
        if (wVar != null) {
            wVar2 = this.Sk.RG;
            wVar2.handleAction(21, null);
        }
    }
}
