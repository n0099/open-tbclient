package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.atomData.bg;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.data.SearchFriendResult;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
class e extends HttpMessageListener {
    final /* synthetic */ SearchFriendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.a = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        h hVar;
        h hVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
            hVar = this.a.a;
            hVar.a(true);
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (httpResponsedMessage instanceof ResponseSearchFriendMessage) {
                ResponseSearchFriendMessage responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo.size() > 0) {
                        hVar2 = this.a.a;
                        hVar2.a((String) null);
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        this.a.sendMessage(new CustomMessage(2002003, new bg(this.a, String.valueOf(userInfo2.getUserId()), userInfo2.getUserName(), null, "search")));
                        return;
                    }
                    this.a.showToast(this.a.getString(x.neterror));
                } else if (TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.a.showToast(this.a.getString(x.neterror));
                } else {
                    this.a.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
