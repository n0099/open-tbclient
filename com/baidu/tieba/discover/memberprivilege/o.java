package com.baidu.tieba.discover.memberprivilege;

import com.baidu.tbadk.core.view.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements u {
    final /* synthetic */ n apV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.apV = nVar;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        MemberPrivilegeActivity memberPrivilegeActivity;
        if (z) {
            memberPrivilegeActivity = this.apV.apz;
            memberPrivilegeActivity.AX();
        }
    }
}
