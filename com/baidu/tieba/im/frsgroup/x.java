package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
final class x implements AdapterView.OnItemClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ah ahVar;
        ahVar = this.a.b;
        ad h = ahVar.h();
        UserData userData = (UserData) h.getItem(i);
        if (userData != null) {
            if (h.d()) {
                if (!userData.getPermission().isController()) {
                    h.a(Long.valueOf(userData.getUserIdLong()));
                    return;
                }
                return;
            }
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(this.a, new StringBuilder(String.valueOf(userData.getUserId())).toString(), userData.getUserName())));
        }
    }
}
