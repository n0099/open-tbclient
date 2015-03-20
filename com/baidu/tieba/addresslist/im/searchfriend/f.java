package com.baidu.tieba.addresslist.im.searchfriend;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.data.SearchFriendResult;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
class f extends HttpMessageListener {
    final /* synthetic */ SearchFriendActivity ayX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.ayX = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        j jVar;
        j jVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
            jVar = this.ayX.ayN;
            jVar.bo(true);
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (httpResponsedMessage instanceof ResponseSearchFriendMessage) {
                ResponseSearchFriendMessage responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo != null && userInfo.size() > 0) {
                        jVar2 = this.ayX.ayN;
                        jVar2.ff(null);
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (userInfo2 == null) {
                            this.ayX.showToast(this.ayX.getPageContext().getString(y.neterror));
                            return;
                        } else {
                            this.ayX.sendMessage(new CustomMessage(2001272, userInfo2));
                            return;
                        }
                    }
                    this.ayX.showToast(this.ayX.getPageContext().getString(y.neterror));
                } else if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    this.ayX.showToast(this.ayX.getPageContext().getString(y.neterror));
                } else {
                    this.ayX.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
