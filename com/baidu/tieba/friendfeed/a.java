package com.baidu.tieba.friendfeed;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.ayU = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.q)) {
            com.baidu.tbadk.core.data.q qVar = (com.baidu.tbadk.core.data.q) customResponsedMessage.getData();
            this.ayU.ayF = qVar.getId();
            str = this.ayU.ayF;
            if (TextUtils.isEmpty(str) || qVar.getPraise() == null) {
                return;
            }
            this.ayU.eD(qVar.getPraise().getIsLike());
        }
    }
}
