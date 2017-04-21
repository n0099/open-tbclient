package com.baidu.tieba.emotion.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView bFB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EmotionTabWidgetView emotionTabWidgetView) {
        this.bFB = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        jVar = this.bFB.KO;
        if (jVar != null) {
            jVar2 = this.bFB.KO;
            jVar2.b(new com.baidu.tbadk.editortools.a(3, -1, null));
        }
    }
}
