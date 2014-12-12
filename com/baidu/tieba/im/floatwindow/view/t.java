package com.baidu.tieba.im.floatwindow.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.im.chat.ar {
    final /* synthetic */ FloatingPersonalChatActivity aYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.aYF = floatingPersonalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void onFirstHistoryPageLoaded() {
        String str;
        AbsMsglistView absMsglistView;
        MsglistModel msglistModel;
        str = this.aYF.ahu;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(str, 2)));
        absMsglistView = this.aYF.mListView;
        msglistModel = this.aYF.mListModel;
        absMsglistView.refreshGo2New(msglistModel.getData());
    }
}
