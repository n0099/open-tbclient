package com.baidu.tieba.enterForum.tabfeed.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.b.a;
import com.squareup.wire.Wire;
import tbclient.Tabfeedlist.TabfeedlistResIdl;
/* loaded from: classes9.dex */
public class TabFeedListHttpResponsedMessage extends TbHttpResponsedMessage {
    public a enterForumTabFeedData;

    public TabFeedListHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_TAB_FEED_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        TabfeedlistResIdl tabfeedlistResIdl = (TabfeedlistResIdl) new Wire(new Class[0]).parseFrom(bArr, TabfeedlistResIdl.class);
        if (tabfeedlistResIdl.error != null && tabfeedlistResIdl.error.errorno != null) {
            setError(tabfeedlistResIdl.error.errorno.intValue());
        }
        if (tabfeedlistResIdl.error != null && tabfeedlistResIdl.error.usermsg != null && tabfeedlistResIdl.error.usermsg.length() > 0) {
            setErrorString(tabfeedlistResIdl.error.usermsg);
        }
        if (getError() == 0 && tabfeedlistResIdl.data != null) {
            this.enterForumTabFeedData = new a();
            this.enterForumTabFeedData.a(tabfeedlistResIdl.data);
        }
    }
}
