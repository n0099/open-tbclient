package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aRx;
    final /* synthetic */ PersonalTalkSettingActivity aVj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PersonalTalkSettingActivity personalTalkSettingActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.aVj = personalTalkSettingActivity;
        this.aRx = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aRx.dismiss();
    }
}
