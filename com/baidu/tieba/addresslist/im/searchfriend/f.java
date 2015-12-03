package com.baidu.tieba.addresslist.im.searchfriend;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.data.SearchFriendResult;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
class f extends HttpMessageListener {
    final /* synthetic */ SearchFriendActivity aJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.aJw = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        j jVar;
        j jVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
            jVar = this.aJw.aJl;
            jVar.bL(true);
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (httpResponsedMessage instanceof ResponseSearchFriendMessage) {
                ResponseSearchFriendMessage responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo != null && userInfo.size() > 0) {
                        jVar2 = this.aJw.aJl;
                        jVar2.gv(null);
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (userInfo2 == null) {
                            this.aJw.showToast(this.aJw.getPageContext().getString(n.i.neterror));
                            return;
                        } else {
                            this.aJw.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_GET_OFFICIAL_ACCOUNT, userInfo2));
                            return;
                        }
                    }
                    this.aJw.showToast(this.aJw.getPageContext().getString(n.i.neterror));
                } else if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    this.aJw.showToast(this.aJw.getPageContext().getString(n.i.neterror));
                } else {
                    this.aJw.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
