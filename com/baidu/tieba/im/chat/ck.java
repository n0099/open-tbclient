package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class ck implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ PersonalChatActivity aSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(PersonalChatActivity personalChatActivity) {
        this.aSN = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.aSN.mListView.closeNotNotify();
            } else {
                this.aSN.mListView.showNotNotfiy();
            }
        }
    }
}
