package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.searchfriend.cache.RequestRecommendWriteMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ SearchFriendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.a = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        l lVar;
        l lVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
            s sVar = (s) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(sVar.a) && !TextUtils.isEmpty(sVar.b)) {
                lVar = this.a.d;
                lVar.a(sVar.a, sVar.b);
                SearchFriendActivity searchFriendActivity = this.a;
                lVar2 = this.a.d;
                searchFriendActivity.sendMessage(new RequestRecommendWriteMessage(lVar2.a()));
            }
        }
    }
}
