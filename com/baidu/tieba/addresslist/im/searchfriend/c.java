package com.baidu.tieba.addresslist.im.searchfriend;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.addresslist.im.searchfriend.cache.RequestRecommendWriteMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ SearchFriendActivity aAR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.aAR = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        n nVar;
        n nVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.i)) {
            com.baidu.tbadk.coreExtra.data.i iVar = (com.baidu.tbadk.coreExtra.data.i) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(iVar.userId) && !TextUtils.isEmpty(iVar.userName)) {
                nVar = this.aAR.aAJ;
                nVar.aq(iVar.userId, iVar.userName);
                SearchFriendActivity searchFriendActivity = this.aAR;
                nVar2 = this.aAR.aAJ;
                searchFriendActivity.sendMessage(new RequestRecommendWriteMessage(nVar2.Gf()));
            }
        }
    }
}
