package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class x implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ OfficialBarChatActivity aZk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(OfficialBarChatActivity officialBarChatActivity) {
        this.aZk = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.aZk.mListView;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.aZk.mListView;
            absMsglistView.showNotNotfiy();
        }
    }
}
