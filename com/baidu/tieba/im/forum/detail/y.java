package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class y implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ ItemMsgManage bbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ItemMsgManage itemMsgManage) {
        this.bbq = itemMsgManage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            this.bbq.setSwitch(bool.booleanValue());
        }
    }
}
