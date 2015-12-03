package com.baidu.tieba.addresslist.im.searchfriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.addresslist.im.searchfriend.cache.ResponseRecommendReadMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ SearchFriendActivity aJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.aJw = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        m mVar;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseRecommendReadMessage)) {
            mVar = this.aJw.aJo;
            mVar.a(((ResponseRecommendReadMessage) customResponsedMessage).getData());
            RequestRecommendMessage requestRecommendMessage = new RequestRecommendMessage();
            requestRecommendMessage.setHeight(com.baidu.adp.lib.util.k.K(this.aJw.getPageContext().getPageActivity()));
            requestRecommendMessage.setWidth(com.baidu.adp.lib.util.k.L(this.aJw.getPageContext().getPageActivity()));
            requestRecommendMessage.setDpi(this.aJw.getResources().getDisplayMetrics().density);
            requestRecommendMessage.setQuality("80");
            this.aJw.sendMessage(requestRecommendMessage);
        }
    }
}
