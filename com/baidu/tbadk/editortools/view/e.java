package com.baidu.tbadk.editortools.view;

import android.view.View;
import com.baidu.tbadk.editortools.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ CommonTabWidgetView asN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonTabWidgetView commonTabWidgetView) {
        this.asN = commonTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        l lVar2;
        lVar = this.asN.BV;
        if (lVar != null) {
            lVar2 = this.asN.BV;
            lVar2.b(new com.baidu.tbadk.editortools.a(3, 3, null));
        }
    }
}
