package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        af afVar;
        com.baidu.tieba.im.model.u uVar;
        af afVar2;
        afVar = this.a.b;
        if (afVar.f().d()) {
            return false;
        }
        uVar = this.a.c;
        if (uVar.b()) {
            afVar2 = this.a.b;
            UserData userData = (UserData) afVar2.f().getItem(i);
            if (userData != null) {
                if (userData.getPermission().isController()) {
                    return false;
                }
                long userIdLong = userData.getUserIdLong();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(userIdLong));
                com.baidu.tieba.im.d.b.a((Activity) this.a, (DialogInterface.OnClickListener) new w(this, arrayList), (DialogInterface.OnClickListener) new x(this));
            }
            return true;
        }
        return false;
    }
}
