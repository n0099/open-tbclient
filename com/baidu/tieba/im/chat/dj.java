package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class dj implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ PersonalChatActivity aPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(PersonalChatActivity personalChatActivity) {
        this.aPW = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.aPW.aQd.closeNotNotify();
            } else {
                this.aPW.aQd.showNotNotfiy();
            }
        }
    }
}
