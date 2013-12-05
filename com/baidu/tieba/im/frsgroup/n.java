package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MembersActivity f1715a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MembersActivity membersActivity) {
        this.f1715a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        aa aaVar;
        com.baidu.tieba.im.model.h hVar;
        aa aaVar2;
        aaVar = this.f1715a.b;
        if (aaVar.i().d()) {
            return false;
        }
        hVar = this.f1715a.c;
        if (hVar.c()) {
            aaVar2 = this.f1715a.b;
            UserData userData = (UserData) aaVar2.i().getItem(i);
            if (userData != null) {
                if (userData.getPermission().isController()) {
                    return false;
                }
                long userId = userData.getUserId();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(userId));
                com.baidu.tieba.im.e.b.a(this.f1715a, new o(this, arrayList), new p(this));
            }
            return true;
        }
        return false;
    }
}
