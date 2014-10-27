package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class bh implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupSettingActivity aOo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(GroupSettingActivity groupSettingActivity) {
        this.aOo = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        bp bpVar;
        bp bpVar2;
        if (bool == null || !bool.equals(true)) {
            bpVar = this.aOo.aOh;
            bpVar.JQ().gO();
            this.aOo.isAcceptNotify = false;
            return;
        }
        bpVar2 = this.aOo.aOh;
        bpVar2.JQ().gN();
        this.aOo.isAcceptNotify = true;
    }
}
