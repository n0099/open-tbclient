package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {
    final /* synthetic */ k aTC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aTC = kVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        CreateGroupStepActivity createGroupStepActivity;
        int i2;
        CreateGroupStepActivity createGroupStepActivity2;
        CreateGroupStepActivity createGroupStepActivity3;
        CreateGroupStepActivity createGroupStepActivity4;
        createGroupStepActivity = this.aTC.aTB;
        i2 = createGroupStepActivity.sourceFrom;
        if (1012 != i2) {
            createGroupStepActivity3 = this.aTC.aTB;
            createGroupStepActivity4 = this.aTC.aTB;
            createGroupStepActivity3.sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(createGroupStepActivity4, TbadkApplication.getCurrentAccount(), 0)));
        }
        createGroupStepActivity2 = this.aTC.aTB;
        createGroupStepActivity2.finish();
    }
}
