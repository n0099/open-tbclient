package com.baidu.tbadk.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EmotionTabWidgetView emotionTabWidgetView) {
        this.a = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        w wVar2;
        wVar = this.a.c;
        if (wVar != null) {
            wVar2 = this.a.c;
            wVar2.a(21, null);
        }
    }
}
