package com.baidu.tieba.im.searchfriend;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class a implements m {
    final /* synthetic */ SearchFriendActivity bnY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SearchFriendActivity searchFriendActivity) {
        this.bnY = searchFriendActivity;
    }

    @Override // com.baidu.tieba.im.searchfriend.m
    public void hh(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        this.bnY.sendMessage(httpMessage);
    }
}
