package com.baidu.tieba.friendFeed;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ FriendFeedActivity aHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.aHM = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.w)) {
            com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) customResponsedMessage.getData();
            this.aHM.aHz = wVar.getId();
            str = this.aHM.aHz;
            if (TextUtils.isEmpty(str) || wVar.getPraise() == null) {
                return;
            }
            this.aHM.eE(wVar.getPraise().getIsLike());
        }
    }
}
