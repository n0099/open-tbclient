package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MembersActivity f1656a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MembersActivity membersActivity) {
        this.f1656a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        aa aaVar;
        aaVar = this.f1656a.f1641a;
        w i2 = aaVar.i();
        UserData userData = (UserData) i2.getItem(i);
        if (userData != null) {
            if (i2.d()) {
                if (!userData.getPermission().isController()) {
                    i2.a(Long.valueOf(userData.getUserId()));
                    return;
                }
                return;
            }
            PersonInfoActivity.a(this.f1656a, userData.getUserId() + "", userData.getUserName());
        }
    }
}
