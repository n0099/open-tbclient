package com.baidu.tieba.emotion.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView bDr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EmotionTabWidgetView emotionTabWidgetView) {
        this.bDr = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        jVar = this.bDr.Ll;
        if (jVar != null) {
            jVar2 = this.bDr.Ll;
            jVar2.b(new com.baidu.tbadk.editortools.a(3, -1, null));
        }
    }
}
