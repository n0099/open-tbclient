package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.person.cm;
/* loaded from: classes.dex */
final class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ae aeVar;
        aeVar = this.a.b;
        aa h = aeVar.h();
        UserData userData = (UserData) h.getItem(i);
        if (userData != null) {
            if (h.d()) {
                if (!userData.getPermission().isController()) {
                    h.a(Long.valueOf(userData.getUserIdLong()));
                    return;
                }
                return;
            }
            cm.a(this.a, new StringBuilder(String.valueOf(userData.getUserId())).toString(), userData.getUserName());
        }
    }
}
