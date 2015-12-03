package com.baidu.tieba.addresslist.im.searchfriend;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.addresslist.im.searchfriend.cache.RequestRecommendWriteMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ SearchFriendActivity aJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.aJw = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        m mVar;
        m mVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.k)) {
            com.baidu.tbadk.coreExtra.data.k kVar = (com.baidu.tbadk.coreExtra.data.k) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(kVar.userId) && !TextUtils.isEmpty(kVar.userName)) {
                mVar = this.aJw.aJo;
                mVar.aq(kVar.userId, kVar.userName);
                SearchFriendActivity searchFriendActivity = this.aJw;
                mVar2 = this.aJw.aJo;
                searchFriendActivity.sendMessage(new RequestRecommendWriteMessage(mVar2.HB()));
            }
        }
    }
}
