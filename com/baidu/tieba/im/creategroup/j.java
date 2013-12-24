package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
/* loaded from: classes.dex */
class j implements DialogInterface.OnClickListener {
    final /* synthetic */ AddGroupInfoData a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, AddGroupInfoData addGroupInfoData) {
        this.b = iVar;
        this.a = addGroupInfoData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.a.finish();
        GroupCardActivity.a(this.b.a, this.a.getGroupId(), this.a.getName(), this.a.getPortrait());
    }
}
