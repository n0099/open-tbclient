package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MembersActivity f1573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MembersActivity membersActivity) {
        this.f1573a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.model.h hVar;
        ae aeVar;
        hVar = this.f1573a.b;
        if (hVar.c()) {
            aeVar = this.f1573a.f1551a;
            UserData userData = (UserData) aeVar.i().getItem(i);
            if (userData != null) {
                if (userData.getPermission().isController()) {
                    return false;
                }
                long userId = userData.getUserId();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(userId));
                com.baidu.tieba.im.d.a.a(this.f1573a, new s(this, arrayList), new t(this));
            }
            return true;
        }
        return false;
    }
}
