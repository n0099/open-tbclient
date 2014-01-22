package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ac acVar;
        com.baidu.tieba.im.model.n nVar;
        ac acVar2;
        acVar = this.a.b;
        if (acVar.i().d()) {
            return false;
        }
        nVar = this.a.c;
        if (nVar.b()) {
            acVar2 = this.a.b;
            UserData userData = (UserData) acVar2.i().getItem(i);
            if (userData != null) {
                if (userData.getPermission().isController()) {
                    return false;
                }
                long userId = userData.getUserId();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(userId));
                com.baidu.tieba.im.d.b.a((Activity) this.a, (DialogInterface.OnClickListener) new q(this, arrayList), (DialogInterface.OnClickListener) new r(this));
            }
            return true;
        }
        return false;
    }
}
