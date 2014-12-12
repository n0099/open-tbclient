package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class ch implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ PersonalChatActivity aRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(PersonalChatActivity personalChatActivity) {
        this.aRE = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.aRE.mListView.closeNotNotify();
            } else {
                this.aRE.mListView.showNotNotfiy();
            }
        }
    }
}
