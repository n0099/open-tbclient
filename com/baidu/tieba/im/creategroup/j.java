package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
/* loaded from: classes.dex */
class j implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AddGroupInfoData f1626a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, AddGroupInfoData addGroupInfoData) {
        this.b = iVar;
        this.f1626a = addGroupInfoData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.f1625a.finish();
        GroupCardActivity.a(this.b.f1625a, this.f1626a.getGroupId(), this.f1626a.getName(), this.f1626a.getPortrait());
    }
}
