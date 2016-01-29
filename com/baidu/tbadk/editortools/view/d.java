package com.baidu.tbadk.editortools.view;

import android.view.View;
import com.baidu.tbadk.editortools.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ CommonTabWidgetView awf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CommonTabWidgetView commonTabWidgetView) {
        this.awf = commonTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar;
        k kVar2;
        kVar = this.awf.Lx;
        if (kVar != null) {
            kVar2 = this.awf.Lx;
            kVar2.b(new com.baidu.tbadk.editortools.a(3, 3, null));
        }
    }
}
