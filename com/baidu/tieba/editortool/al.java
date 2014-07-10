package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ PrivilegeTabHorizonScrollView a;
    private final int b;

    private al(PrivilegeTabHorizonScrollView privilegeTabHorizonScrollView, int i) {
        this.a = privilegeTabHorizonScrollView;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(PrivilegeTabHorizonScrollView privilegeTabHorizonScrollView, int i, al alVar) {
        this(privilegeTabHorizonScrollView, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PrivilegeTabHorizonScrollView.a(this.a).a(this.b);
    }
}
