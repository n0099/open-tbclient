package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class y implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ ItemMsgManage bbr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ItemMsgManage itemMsgManage) {
        this.bbr = itemMsgManage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            this.bbr.setSwitch(bool.booleanValue());
        }
    }
}
