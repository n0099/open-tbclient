package com.baidu.tbadk.editortools.view;

import android.view.View;
import com.baidu.tbadk.editortools.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ CommonTabWidgetView aBP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonTabWidgetView commonTabWidgetView) {
        this.aBP = commonTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar;
        j jVar2;
        jVar = this.aBP.Ll;
        if (jVar != null) {
            jVar2 = this.aBP.Ll;
            jVar2.b(new com.baidu.tbadk.editortools.a(3, 3, null));
        }
    }
}
