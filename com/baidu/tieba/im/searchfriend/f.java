package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.data.SearchFriendResult;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
class f extends HttpMessageListener {
    final /* synthetic */ SearchFriendActivity bmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.bmC = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        j jVar;
        j jVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
            jVar = this.bmC.bmt;
            jVar.df(true);
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (httpResponsedMessage instanceof ResponseSearchFriendMessage) {
                ResponseSearchFriendMessage responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo != null && userInfo.size() > 0) {
                        jVar2 = this.bmC.bmt;
                        jVar2.hg(null);
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (userInfo2 == null) {
                            this.bmC.showToast(this.bmC.getPageContext().getString(z.neterror));
                            return;
                        } else {
                            this.bmC.sendMessage(new CustomMessage(2001272, userInfo2));
                            return;
                        }
                    }
                    this.bmC.showToast(this.bmC.getPageContext().getString(z.neterror));
                } else if (TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.bmC.showToast(this.bmC.getPageContext().getString(z.neterror));
                } else {
                    this.bmC.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
