package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.MembersModel;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements DialogInterface.OnClickListener {
    final /* synthetic */ MembersActivity aXN;
    private final /* synthetic */ List aXQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MembersActivity membersActivity, List list) {
        this.aXN = membersActivity;
        this.aXQ = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ah ahVar;
        ah ahVar2;
        ah ahVar3;
        MembersModel membersModel;
        ah ahVar4;
        ahVar = this.aXN.aXJ;
        ahVar.db(false);
        ahVar2 = this.aXN.aXJ;
        ahVar2.NO().cZ(false);
        ahVar3 = this.aXN.aXJ;
        ahVar3.NP();
        MembersActivity membersActivity = this.aXN;
        membersModel = this.aXN.aXK;
        membersActivity.a(membersModel.getGroupId(), this.aXQ);
        ahVar4 = this.aXN.aXJ;
        ahVar4.dc(true);
    }
}
