package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
/* loaded from: classes.dex */
class l implements DialogInterface.OnClickListener {
    final /* synthetic */ AddGroupInfoData a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, AddGroupInfoData addGroupInfoData) {
        this.b = kVar;
        this.a = addGroupInfoData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.a.finish();
        GroupCardActivity.a(this.b.a, this.a.getGroupId(), this.a.getName(), this.a.getPortrait());
    }
}
