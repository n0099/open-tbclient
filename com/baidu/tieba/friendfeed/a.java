package com.baidu.tieba.friendfeed;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ FriendFeedActivity aBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.aBV = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.x)) {
            com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) customResponsedMessage.getData();
            this.aBV.aBJ = xVar.getId();
            str = this.aBV.aBJ;
            if (TextUtils.isEmpty(str) || xVar.getPraise() == null) {
                return;
            }
            this.aBV.eH(xVar.getPraise().getIsLike());
        }
    }
}
