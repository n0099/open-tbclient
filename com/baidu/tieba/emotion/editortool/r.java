package com.baidu.tieba.emotion.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EmotionTabWidgetView emotionTabWidgetView) {
        this.bIv = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        lVar = this.bIv.EL;
        if (lVar != null) {
            lVar2 = this.bIv.EL;
            lVar2.b(new com.baidu.tbadk.editortools.a(3, -1, null));
        }
    }
}
