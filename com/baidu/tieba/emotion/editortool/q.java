package com.baidu.tieba.emotion.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView aKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EmotionTabWidgetView emotionTabWidgetView) {
        this.aKX = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        jVar = this.aKX.KB;
        if (jVar != null) {
            jVar2 = this.aKX.KB;
            jVar2.b(new com.baidu.tbadk.editortools.a(3, -1, null));
        }
    }
}
