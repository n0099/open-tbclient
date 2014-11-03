package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class bh implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupSettingActivity aOC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(GroupSettingActivity groupSettingActivity) {
        this.aOC = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        bp bpVar;
        bp bpVar2;
        if (bool == null || !bool.equals(true)) {
            bpVar = this.aOC.aOv;
            bpVar.JU().gO();
            this.aOC.isAcceptNotify = false;
            return;
        }
        bpVar2 = this.aOC.aOv;
        bpVar2.JU().gN();
        this.aOC.isAcceptNotify = true;
    }
}
