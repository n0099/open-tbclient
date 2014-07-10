package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ PrivilegeTabWidgetView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PrivilegeTabWidgetView privilegeTabWidgetView) {
        this.a = privilegeTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        com.baidu.tbadk.editortool.w wVar2;
        wVar = this.a.c;
        if (wVar != null) {
            wVar2 = this.a.c;
            wVar2.a(21, null);
        }
    }
}
