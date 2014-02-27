package com.baidu.tieba.im.frsgroup;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.UserData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ae aeVar;
        com.baidu.tieba.im.model.l lVar;
        ae aeVar2;
        aeVar = this.a.b;
        if (aeVar.h().d()) {
            return false;
        }
        lVar = this.a.c;
        if (lVar.b()) {
            aeVar2 = this.a.b;
            UserData userData = (UserData) aeVar2.h().getItem(i);
            if (userData != null) {
                if (userData.getPermission().isController()) {
                    return false;
                }
                long userIdLong = userData.getUserIdLong();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(userIdLong));
                MembersActivity membersActivity = this.a;
                v vVar = new v(this, arrayList);
                new AlertDialog.Builder(membersActivity).setTitle(R.string.del_post_tip).setMessage(R.string.members_dialog_remove_one_message).setPositiveButton(R.string.alert_yes_button, vVar).setNegativeButton(R.string.alert_no_button, new w(this)).create().show();
            }
            return true;
        }
        return false;
    }
}
