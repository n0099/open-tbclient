package com.baidu.tieba.addresslist.im.searchfriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.addresslist.im.searchfriend.cache.ResponseRecommendReadMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ SearchFriendActivity aAQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.aAQ = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        n nVar;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseRecommendReadMessage)) {
            nVar = this.aAQ.aAI;
            nVar.a(((ResponseRecommendReadMessage) customResponsedMessage).getData());
            RequestRecommendMessage requestRecommendMessage = new RequestRecommendMessage();
            requestRecommendMessage.setHeight(com.baidu.adp.lib.util.n.M(this.aAQ.getPageContext().getPageActivity()));
            requestRecommendMessage.setWidth(com.baidu.adp.lib.util.n.N(this.aAQ.getPageContext().getPageActivity()));
            requestRecommendMessage.setDpi(this.aAQ.getResources().getDisplayMetrics().density);
            requestRecommendMessage.setQuality("80");
            this.aAQ.sendMessage(requestRecommendMessage);
        }
    }
}
