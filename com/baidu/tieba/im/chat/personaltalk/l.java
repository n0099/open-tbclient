package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class l implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity aTQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aTQ = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        o oVar;
        com.baidu.tbadk.core.i.B(this.aTQ.getPageContext().getContext(), "personalchat_morepage_addblack");
        oVar = this.aTQ.aTP;
        oVar.cz(true);
    }
}
