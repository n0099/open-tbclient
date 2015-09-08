package com.baidu.tbadk.editortools.emotiontool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ EmotionTabWidgetView asb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabWidgetView emotionTabWidgetView) {
        this.asb = emotionTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        jVar = this.asb.Kz;
        if (jVar != null) {
            jVar2 = this.asb.Kz;
            jVar2.b(new com.baidu.tbadk.editortools.a(3, -1, null));
        }
    }
}
