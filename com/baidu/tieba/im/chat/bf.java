package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.ReportGroupModel;
/* loaded from: classes.dex */
class bf implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity aOC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(GroupSettingActivity groupSettingActivity) {
        this.aOC = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ReportGroupModel reportGroupModel;
        ReportGroupModel reportGroupModel2;
        bm bmVar;
        ReportGroupModel reportGroupModel3;
        ReportGroupModel reportGroupModel4;
        reportGroupModel = this.aOC.aOy;
        if (reportGroupModel == null) {
            this.aOC.aOy = new ReportGroupModel(this.aOC);
        }
        reportGroupModel2 = this.aOC.aOy;
        bmVar = this.aOC.aOw;
        reportGroupModel2.setGroupId(Integer.parseInt(bmVar.getGroupId()));
        reportGroupModel3 = this.aOC.aOy;
        reportGroupModel3.setReportType(i);
        reportGroupModel4 = this.aOC.aOy;
        reportGroupModel4.sendMessage();
    }
}
