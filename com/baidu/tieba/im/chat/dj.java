package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class dj implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ PersonalChatActivity aPI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(PersonalChatActivity personalChatActivity) {
        this.aPI = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.aPI.aPP.closeNotNotify();
            } else {
                this.aPI.aPP.showNotNotfiy();
            }
        }
    }
}
