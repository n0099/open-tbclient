package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ PrivilegeTabWidgetView arX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PrivilegeTabWidgetView privilegeTabWidgetView) {
        this.arX = privilegeTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        com.baidu.tbadk.editortool.w wVar2;
        wVar = this.arX.RG;
        if (wVar != null) {
            wVar2 = this.arX.RG;
            wVar2.handleAction(21, null);
        }
    }
}
