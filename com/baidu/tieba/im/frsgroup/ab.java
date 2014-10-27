package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.MembersModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements DialogInterface.OnClickListener {
    final /* synthetic */ MembersActivity aXN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MembersActivity membersActivity) {
        this.aXN = membersActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MembersModel membersModel;
        ah ahVar;
        int i2 = 0;
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
        }
        membersModel = this.aXN.aXK;
        membersModel.setOrderType(i2);
        ahVar = this.aXN.aXJ;
        ahVar.fK(i);
        this.aXN.reset();
    }
}
