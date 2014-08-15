package com.baidu.tieba.im.searchfriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.searchfriend.cache.ResponseRecommendReadMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ SearchFriendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.a = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        l lVar;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseRecommendReadMessage)) {
            lVar = this.a.d;
            lVar.a(((ResponseRecommendReadMessage) customResponsedMessage).getData());
            RequestRecommendMessage requestRecommendMessage = new RequestRecommendMessage();
            requestRecommendMessage.setHeight(com.baidu.adp.lib.util.j.b(this.a));
            requestRecommendMessage.setWidth(com.baidu.adp.lib.util.j.c(this.a));
            requestRecommendMessage.setDpi(this.a.getResources().getDisplayMetrics().density);
            requestRecommendMessage.setQuality("80");
            this.a.sendMessage(requestRecommendMessage);
        }
    }
}
