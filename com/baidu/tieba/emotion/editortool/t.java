package com.baidu.tieba.emotion.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView bRX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(EmotionTabWidgetView emotionTabWidgetView) {
        this.bRX = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        jVar = this.bRX.JT;
        if (jVar != null) {
            jVar2 = this.bRX.JT;
            jVar2.b(new com.baidu.tbadk.editortools.a(3, -1, null));
        }
    }
}
