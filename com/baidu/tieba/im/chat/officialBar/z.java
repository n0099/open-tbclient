package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class z implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ OfficialBarChatActivity aRt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(OfficialBarChatActivity officialBarChatActivity) {
        this.aRt = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.aRt.aQd;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.aRt.aQd;
            absMsglistView.showNotNotfiy();
        }
    }
}
