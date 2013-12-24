package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        aa aaVar;
        com.baidu.tieba.im.model.m mVar;
        aa aaVar2;
        aaVar = this.a.b;
        if (aaVar.i().d()) {
            return false;
        }
        mVar = this.a.c;
        if (mVar.b()) {
            aaVar2 = this.a.b;
            UserData userData = (UserData) aaVar2.i().getItem(i);
            if (userData != null) {
                if (userData.getPermission().isController()) {
                    return false;
                }
                long userId = userData.getUserId();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(userId));
                com.baidu.tieba.im.d.b.a(this.a, new o(this, arrayList), new p(this));
            }
            return true;
        }
        return false;
    }
}
