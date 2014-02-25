package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ae aeVar;
        com.baidu.tieba.im.model.l lVar;
        ae aeVar2;
        aeVar = this.a.b;
        if (aeVar.i().d()) {
            return false;
        }
        lVar = this.a.c;
        if (lVar.b()) {
            aeVar2 = this.a.b;
            UserData userData = (UserData) aeVar2.i().getItem(i);
            if (userData != null) {
                if (userData.getPermission().isController()) {
                    return false;
                }
                long userIdLong = userData.getUserIdLong();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(userIdLong));
                com.baidu.tieba.im.util.b.a((Activity) this.a, (DialogInterface.OnClickListener) new v(this, arrayList), (DialogInterface.OnClickListener) new w(this));
            }
            return true;
        }
        return false;
    }
}
