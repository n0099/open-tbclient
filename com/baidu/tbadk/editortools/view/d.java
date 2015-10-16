package com.baidu.tbadk.editortools.view;

import android.view.View;
import com.baidu.tbadk.editortools.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ CommonTabWidgetView asV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CommonTabWidgetView commonTabWidgetView) {
        this.asV = commonTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar;
        j jVar2;
        jVar = this.asV.KA;
        if (jVar != null) {
            jVar2 = this.asV.KA;
            jVar2.b(new com.baidu.tbadk.editortools.a(3, 3, null));
        }
    }
}
