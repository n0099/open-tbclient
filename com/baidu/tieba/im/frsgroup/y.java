package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ah ahVar;
        com.baidu.tieba.im.model.ad adVar;
        ah ahVar2;
        ahVar = this.a.b;
        if (ahVar.f().d()) {
            return false;
        }
        adVar = this.a.c;
        if (adVar.b()) {
            ahVar2 = this.a.b;
            UserData userData = (UserData) ahVar2.f().getItem(i);
            if (userData != null) {
                if (userData.getPermission().isController()) {
                    return false;
                }
                long userIdLong = userData.getUserIdLong();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(userIdLong));
                com.baidu.tieba.im.e.b.a((Activity) this.a, (DialogInterface.OnClickListener) new z(this, arrayList), (DialogInterface.OnClickListener) new aa(this));
            }
            return true;
        }
        return false;
    }
}
