package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.searchfriend.cache.RequestRecommendWriteMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ SearchFriendActivity bnY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.bnY = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        n nVar;
        n nVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.h)) {
            com.baidu.tbadk.coreExtra.data.h hVar = (com.baidu.tbadk.coreExtra.data.h) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(hVar.userId) && !TextUtils.isEmpty(hVar.userName)) {
                nVar = this.bnY.bnR;
                nVar.ap(hVar.userId, hVar.userName);
                SearchFriendActivity searchFriendActivity = this.bnY;
                nVar2 = this.bnY.bnR;
                searchFriendActivity.sendMessage(new RequestRecommendWriteMessage(nVar2.Tc()));
            }
        }
    }
}
