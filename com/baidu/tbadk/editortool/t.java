package com.baidu.tbadk.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(EmotionTabWidgetView emotionTabWidgetView) {
        this.a = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.a.c;
        if (xVar != null) {
            xVar2 = this.a.c;
            xVar2.a(21, null);
        }
    }
}
