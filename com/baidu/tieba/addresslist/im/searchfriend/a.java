package com.baidu.tieba.addresslist.im.searchfriend;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class a implements m {
    final /* synthetic */ SearchFriendActivity aAQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SearchFriendActivity searchFriendActivity) {
        this.aAQ = searchFriendActivity;
    }

    @Override // com.baidu.tieba.addresslist.im.searchfriend.m
    public void fC(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        this.aAQ.sendMessage(httpMessage);
    }
}
