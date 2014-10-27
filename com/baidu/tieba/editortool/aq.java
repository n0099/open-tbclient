package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    private final int CH;
    final /* synthetic */ PrivilegeTabHorizonScrollView arI;

    private aq(PrivilegeTabHorizonScrollView privilegeTabHorizonScrollView, int i) {
        this.arI = privilegeTabHorizonScrollView;
        this.CH = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aq(PrivilegeTabHorizonScrollView privilegeTabHorizonScrollView, int i, aq aqVar) {
        this(privilegeTabHorizonScrollView, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PrivilegeTabHorizonScrollView.a(this.arI).cH(this.CH);
    }
}
