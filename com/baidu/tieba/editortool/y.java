package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(EmotionTabWidgetView emotionTabWidgetView) {
        this.a = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        aaVar = this.a.c;
        if (aaVar != null) {
            aaVar2 = this.a.c;
            aaVar2.a(21, null);
        }
    }
}
