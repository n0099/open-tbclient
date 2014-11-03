package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnClickListener {
    final /* synthetic */ k aTQ;
    private final /* synthetic */ AddGroupInfoData aTR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, AddGroupInfoData addGroupInfoData) {
        this.aTQ = kVar;
        this.aTR = addGroupInfoData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        CreateGroupStepActivity createGroupStepActivity;
        CreateGroupStepActivity createGroupStepActivity2;
        createGroupStepActivity = this.aTQ.aTP;
        createGroupStepActivity.finish();
        createGroupStepActivity2 = this.aTQ.aTP;
        GroupCardActivity.a(createGroupStepActivity2, this.aTR.getGroupId(), this.aTR.getName(), this.aTR.getPortrait());
    }
}
