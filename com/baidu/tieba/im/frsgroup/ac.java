package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.MembersModel;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements DialogInterface.OnClickListener {
    final /* synthetic */ MembersActivity aYb;
    private final /* synthetic */ List aYe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MembersActivity membersActivity, List list) {
        this.aYb = membersActivity;
        this.aYe = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ah ahVar;
        ah ahVar2;
        ah ahVar3;
        MembersModel membersModel;
        ah ahVar4;
        ahVar = this.aYb.aXX;
        ahVar.db(false);
        ahVar2 = this.aYb.aXX;
        ahVar2.NS().cZ(false);
        ahVar3 = this.aYb.aXX;
        ahVar3.NT();
        MembersActivity membersActivity = this.aYb;
        membersModel = this.aYb.aXY;
        membersActivity.a(membersModel.getGroupId(), this.aYe);
        ahVar4 = this.aYb.aXX;
        ahVar4.dc(true);
    }
}
