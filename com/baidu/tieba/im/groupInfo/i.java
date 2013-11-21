package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupInfoActivity f1682a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(GroupInfoActivity groupInfoActivity) {
        this.f1682a = groupInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.c cVar;
        GroupData group;
        cVar = this.f1682a.g;
        ResponseGroupInfoMessage d = cVar.d();
        if (d != null && (group = d.getGroup()) != null) {
            int flag = group.getFlag();
            if (i == 0) {
                i = flag & (-2);
            } else {
                i = flag | 1;
            }
        }
        this.f1682a.a(i);
    }
}
