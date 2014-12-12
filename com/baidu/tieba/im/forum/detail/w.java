package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class w implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ ItemMsgManage aZU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ItemMsgManage itemMsgManage) {
        this.aZU = itemMsgManage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            this.aZU.setSwitch(bool.booleanValue());
        }
    }
}
