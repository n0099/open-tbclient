package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnClickListener {
    final /* synthetic */ k aTC;
    private final /* synthetic */ AddGroupInfoData aTD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, AddGroupInfoData addGroupInfoData) {
        this.aTC = kVar;
        this.aTD = addGroupInfoData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        CreateGroupStepActivity createGroupStepActivity;
        CreateGroupStepActivity createGroupStepActivity2;
        createGroupStepActivity = this.aTC.aTB;
        createGroupStepActivity.finish();
        createGroupStepActivity2 = this.aTC.aTB;
        GroupCardActivity.a(createGroupStepActivity2, this.aTD.getGroupId(), this.aTD.getName(), this.aTD.getPortrait());
    }
}
