package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class z implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ OfficialBarChatActivity aUp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(OfficialBarChatActivity officialBarChatActivity) {
        this.aUp = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.aUp.mListView;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.aUp.mListView;
            absMsglistView.showNotNotfiy();
        }
    }
}
