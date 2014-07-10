package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {
    final /* synthetic */ j a;
    private final /* synthetic */ AddGroupInfoData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, AddGroupInfoData addGroupInfoData) {
        this.a = jVar;
        this.b = addGroupInfoData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        CreateGroupStepActivity createGroupStepActivity;
        CreateGroupStepActivity createGroupStepActivity2;
        createGroupStepActivity = this.a.a;
        createGroupStepActivity.finish();
        createGroupStepActivity2 = this.a.a;
        GroupCardActivity.a(createGroupStepActivity2, this.b.getGroupId(), this.b.getName(), this.b.getPortrait());
    }
}
