package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.searchfriend.cache.RequestRecommendWriteMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ SearchFriendActivity bhZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.bhZ = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        l lVar;
        l lVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.e)) {
            com.baidu.tbadk.coreExtra.data.e eVar = (com.baidu.tbadk.coreExtra.data.e) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(eVar.userId) && !TextUtils.isEmpty(eVar.userName)) {
                lVar = this.bhZ.bhT;
                lVar.ae(eVar.userId, eVar.userName);
                SearchFriendActivity searchFriendActivity = this.bhZ;
                lVar2 = this.bhZ.bhT;
                searchFriendActivity.sendMessage(new RequestRecommendWriteMessage(lVar2.Rz()));
            }
        }
    }
}
