package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.MembersModel;
import com.baidu.tieba.im.util.DialogUtil;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ MembersActivity aYb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MembersActivity membersActivity) {
        this.aYb = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ah ahVar;
        MembersModel membersModel;
        ah ahVar2;
        ahVar = this.aYb.aXX;
        if (ahVar.NS().NN()) {
            return false;
        }
        membersModel = this.aYb.aXY;
        if (membersModel.isController()) {
            ahVar2 = this.aYb.aXX;
            UserData userData = (UserData) ahVar2.NS().getItem(i);
            if (userData != null) {
                if (userData.getPermission().isController()) {
                    return false;
                }
                long userIdLong = userData.getUserIdLong();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(userIdLong));
                DialogUtil.removeMemberDialog(this.aYb, new y(this, arrayList), new z(this));
            }
            return true;
        }
        return false;
    }
}
