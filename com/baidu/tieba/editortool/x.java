package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(EmotionTabWidgetView emotionTabWidgetView) {
        this.a = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.a.d;
        if (zVar != null) {
            zVar2 = this.a.d;
            zVar2.a(21, null);
        }
    }
}
