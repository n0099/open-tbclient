package com.baidu.tieba.im.selectfriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ b bos;
    private final /* synthetic */ long bot;
    private final /* synthetic */ String bou;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i, long j, String str, String str2) {
        super(i);
        this.bos = bVar;
        this.bot = j;
        this.val$name = str;
        this.bou = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        SelectFriendActivity selectFriendActivity;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2001268) {
            selectFriendActivity = this.bos.bor;
            selectFriendActivity.a((ShareFromGameCenterMsgData) customResponsedMessage.getData(), this.bot, this.val$name, this.bou);
        }
    }
}
