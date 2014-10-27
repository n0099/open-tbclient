package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.MembersModel;
import java.util.List;
/* loaded from: classes.dex */
class y implements DialogInterface.OnClickListener {
    final /* synthetic */ x aXP;
    private final /* synthetic */ List aXQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, List list) {
        this.aXP = xVar;
        this.aXQ = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MembersActivity membersActivity;
        MembersActivity membersActivity2;
        MembersModel membersModel;
        membersActivity = this.aXP.aXN;
        membersActivity2 = this.aXP.aXN;
        membersModel = membersActivity2.aXK;
        membersActivity.a(membersModel.getGroupId(), this.aXQ);
    }
}
