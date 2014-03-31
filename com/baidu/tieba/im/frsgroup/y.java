package com.baidu.tieba.im.frsgroup;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ah ahVar;
        com.baidu.tieba.im.model.y yVar;
        ah ahVar2;
        ahVar = this.a.b;
        if (ahVar.h().d()) {
            return false;
        }
        yVar = this.a.c;
        if (yVar.b()) {
            ahVar2 = this.a.b;
            UserData userData = (UserData) ahVar2.h().getItem(i);
            if (userData != null) {
                if (userData.getPermission().isController()) {
                    return false;
                }
                long userIdLong = userData.getUserIdLong();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(userIdLong));
                MembersActivity membersActivity = this.a;
                z zVar = new z(this, arrayList);
                new AlertDialog.Builder(membersActivity).setTitle(com.baidu.tieba.im.j.del_post_tip).setMessage(com.baidu.tieba.im.j.members_dialog_remove_one_message).setPositiveButton(com.baidu.tieba.im.j.alert_yes_button, zVar).setNegativeButton(com.baidu.tieba.im.j.alert_no_button, new aa(this)).create().show();
            }
            return true;
        }
        return false;
    }
}
