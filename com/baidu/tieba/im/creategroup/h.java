package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
/* loaded from: classes.dex */
class h implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AddGroupInfoData f1587a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, AddGroupInfoData addGroupInfoData) {
        this.b = gVar;
        this.f1587a = addGroupInfoData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.f1586a.finish();
        GroupCardActivity.a(this.b.f1586a, this.f1587a.getGroupId(), this.f1587a.getName(), this.f1587a.getPortrait());
    }
}
