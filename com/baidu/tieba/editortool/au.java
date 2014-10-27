package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ PrivilegeTabWidgetView arO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PrivilegeTabWidgetView privilegeTabWidgetView) {
        this.arO = privilegeTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        com.baidu.tbadk.editortool.w wVar2;
        wVar = this.arO.RC;
        if (wVar != null) {
            wVar2 = this.arO.RC;
            wVar2.handleAction(21, null);
        }
    }
}
