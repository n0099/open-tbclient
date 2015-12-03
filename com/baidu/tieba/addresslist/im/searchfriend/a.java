package com.baidu.tieba.addresslist.im.searchfriend;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.addresslist.im.searchfriend.j;
/* loaded from: classes.dex */
class a implements j.a {
    final /* synthetic */ SearchFriendActivity aJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SearchFriendActivity searchFriendActivity) {
        this.aJw = searchFriendActivity;
    }

    @Override // com.baidu.tieba.addresslist.im.searchfriend.j.a
    public void gu(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        this.aJw.sendMessage(httpMessage);
    }
}
