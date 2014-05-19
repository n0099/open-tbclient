package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ PrivilegeTabWidgetView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PrivilegeTabWidgetView privilegeTabWidgetView) {
        this.a = privilegeTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.x xVar;
        com.baidu.tbadk.editortool.x xVar2;
        xVar = this.a.c;
        if (xVar != null) {
            xVar2 = this.a.c;
            xVar2.a(21, null);
        }
    }
}
