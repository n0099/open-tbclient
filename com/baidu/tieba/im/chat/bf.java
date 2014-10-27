package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.ReportGroupModel;
/* loaded from: classes.dex */
class bf implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity aOo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(GroupSettingActivity groupSettingActivity) {
        this.aOo = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ReportGroupModel reportGroupModel;
        ReportGroupModel reportGroupModel2;
        bm bmVar;
        ReportGroupModel reportGroupModel3;
        ReportGroupModel reportGroupModel4;
        reportGroupModel = this.aOo.aOk;
        if (reportGroupModel == null) {
            this.aOo.aOk = new ReportGroupModel(this.aOo);
        }
        reportGroupModel2 = this.aOo.aOk;
        bmVar = this.aOo.aOi;
        reportGroupModel2.setGroupId(Integer.parseInt(bmVar.getGroupId()));
        reportGroupModel3 = this.aOo.aOk;
        reportGroupModel3.setReportType(i);
        reportGroupModel4 = this.aOo.aOk;
        reportGroupModel4.sendMessage();
    }
}
