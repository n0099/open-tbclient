package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.data.SearchFriendResult;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
class e extends HttpMessageListener {
    final /* synthetic */ SearchFriendActivity bhZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.bhZ = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        h hVar;
        h hVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
            hVar = this.bhZ.bhR;
            hVar.ds(true);
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (httpResponsedMessage instanceof ResponseSearchFriendMessage) {
                ResponseSearchFriendMessage responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo.size() > 0) {
                        hVar2 = this.bhZ.bhR;
                        hVar2.gC(null);
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        this.bhZ.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bhZ, String.valueOf(userInfo2.getUserId()), userInfo2.getUserName(), null, AddFriendActivityConfig.TYPE_SEARCH)));
                        return;
                    }
                    this.bhZ.showToast(this.bhZ.getString(y.neterror));
                } else if (TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.bhZ.showToast(this.bhZ.getString(y.neterror));
                } else {
                    this.bhZ.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
