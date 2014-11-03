package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.MembersModel;
import java.util.List;
/* loaded from: classes.dex */
class y implements DialogInterface.OnClickListener {
    final /* synthetic */ x aYd;
    private final /* synthetic */ List aYe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, List list) {
        this.aYd = xVar;
        this.aYe = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MembersActivity membersActivity;
        MembersActivity membersActivity2;
        MembersModel membersModel;
        membersActivity = this.aYd.aYb;
        membersActivity2 = this.aYd.aYb;
        membersModel = membersActivity2.aXY;
        membersActivity.a(membersModel.getGroupId(), this.aYe);
    }
}
