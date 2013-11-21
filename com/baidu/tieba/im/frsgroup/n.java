package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MembersActivity f1648a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MembersActivity membersActivity) {
        this.f1648a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.model.h hVar;
        aa aaVar;
        hVar = this.f1648a.b;
        if (hVar.c()) {
            aaVar = this.f1648a.f1632a;
            UserData userData = (UserData) aaVar.i().getItem(i);
            if (userData != null) {
                if (userData.getPermission().isController()) {
                    return false;
                }
                long userId = userData.getUserId();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(userId));
                com.baidu.tieba.im.d.a.a(this.f1648a, new o(this, arrayList), new p(this));
            }
            return true;
        }
        return false;
    }
}
