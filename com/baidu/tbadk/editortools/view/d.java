package com.baidu.tbadk.editortools.view;

import android.view.View;
import com.baidu.tbadk.editortools.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ CommonTabWidgetView arI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CommonTabWidgetView commonTabWidgetView) {
        this.arI = commonTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar;
        j jVar2;
        jVar = this.arI.KB;
        if (jVar != null) {
            jVar2 = this.arI.KB;
            jVar2.b(new com.baidu.tbadk.editortools.a(3, 3, null));
        }
    }
}
