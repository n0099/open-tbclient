package com.baidu.tieba.addresslist.im.searchfriend;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.addresslist.im.searchfriend.cache.RequestRecommendWriteMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ SearchFriendActivity aAQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.aAQ = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        n nVar;
        n nVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.i)) {
            com.baidu.tbadk.coreExtra.data.i iVar = (com.baidu.tbadk.coreExtra.data.i) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(iVar.userId) && !TextUtils.isEmpty(iVar.userName)) {
                nVar = this.aAQ.aAI;
                nVar.aq(iVar.userId, iVar.userName);
                SearchFriendActivity searchFriendActivity = this.aAQ;
                nVar2 = this.aAQ.aAI;
                searchFriendActivity.sendMessage(new RequestRecommendWriteMessage(nVar2.Ge()));
            }
        }
    }
}
