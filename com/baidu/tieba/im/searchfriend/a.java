package com.baidu.tieba.im.searchfriend;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class a implements k {
    final /* synthetic */ SearchFriendActivity bhZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SearchFriendActivity searchFriendActivity) {
        this.bhZ = searchFriendActivity;
    }

    @Override // com.baidu.tieba.im.searchfriend.k
    public void gB(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        this.bhZ.sendMessage(httpMessage);
    }
}
