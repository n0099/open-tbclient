package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
/* loaded from: classes.dex */
final class l implements DialogInterface.OnClickListener {
    final /* synthetic */ j a;
    private final /* synthetic */ AddGroupInfoData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, AddGroupInfoData addGroupInfoData) {
        this.a = jVar;
        this.b = addGroupInfoData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a.finish();
        GroupCardActivity.a(this.a.a, this.b.getGroupId(), this.b.getName(), this.b.getPortrait());
    }
}
