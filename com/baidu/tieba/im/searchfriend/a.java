package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.atomData.bb;
import com.baidu.tieba.im.data.SearchFriendResult;
import com.baidu.tieba.im.message.ResponseSearchFriendMessage;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
class a extends HttpMessageListener {
    final /* synthetic */ SearchFriendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.a = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        EditText editText;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (httpResponsedMessage instanceof ResponseSearchFriendMessage) {
                ResponseSearchFriendMessage responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo.size() > 0) {
                        editText = this.a.d;
                        editText.setText("");
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        this.a.sendMessage(new CustomMessage(2002003, new bb(this.a, String.valueOf(userInfo2.getUserId()), userInfo2.getUserName())));
                        return;
                    }
                    this.a.showToast(y.neterror);
                } else if (TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.a.showToast(y.neterror);
                } else {
                    this.a.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
