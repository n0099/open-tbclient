package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ PrivilegeTabHorizonScrollView a;
    private final int b;

    private aj(PrivilegeTabHorizonScrollView privilegeTabHorizonScrollView, int i) {
        this.a = privilegeTabHorizonScrollView;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aj(PrivilegeTabHorizonScrollView privilegeTabHorizonScrollView, int i, aj ajVar) {
        this(privilegeTabHorizonScrollView, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PrivilegeTabHorizonScrollView.a(this.a).a(this.b);
    }
}
