package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.person.cm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ae aeVar;
        aeVar = this.a.b;
        aa i2 = aeVar.i();
        UserData userData = (UserData) i2.getItem(i);
        if (userData != null) {
            if (i2.d()) {
                if (!userData.getPermission().isController()) {
                    i2.a(Long.valueOf(userData.getUserIdLong()));
                    return;
                }
                return;
            }
            cm.a(this.a, new StringBuilder(String.valueOf(userData.getUserId())).toString(), userData.getUserName());
        }
    }
}
