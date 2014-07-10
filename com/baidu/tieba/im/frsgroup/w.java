package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ag agVar;
        com.baidu.tieba.im.model.ac acVar;
        ag agVar2;
        agVar = this.a.b;
        if (agVar.f().d()) {
            return false;
        }
        acVar = this.a.c;
        if (acVar.b()) {
            agVar2 = this.a.b;
            UserData userData = (UserData) agVar2.f().getItem(i);
            if (userData != null) {
                if (userData.getPermission().isController()) {
                    return false;
                }
                long userIdLong = userData.getUserIdLong();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(userIdLong));
                com.baidu.tieba.im.e.b.a((Activity) this.a, (DialogInterface.OnClickListener) new x(this, arrayList), (DialogInterface.OnClickListener) new y(this));
            }
            return true;
        }
        return false;
    }
}
