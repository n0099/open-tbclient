package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    private final int CI;
    final /* synthetic */ PrivilegeTabHorizonScrollView arR;

    private aq(PrivilegeTabHorizonScrollView privilegeTabHorizonScrollView, int i) {
        this.arR = privilegeTabHorizonScrollView;
        this.CI = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aq(PrivilegeTabHorizonScrollView privilegeTabHorizonScrollView, int i, aq aqVar) {
        this(privilegeTabHorizonScrollView, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PrivilegeTabHorizonScrollView.a(this.arR).cH(this.CI);
    }
}
