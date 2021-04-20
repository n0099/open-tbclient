package com.baidu.tieba.enterForum.tabfeed.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.c.j.e.n;
import d.b.h0.g0.b.a;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.Tabfeedlist.TabfeedlistResIdl;
/* loaded from: classes4.dex */
public class TabFeedListHttpResponsedMessage extends TbHttpResponsedMessage implements a {
    public d.b.i0.i0.l.d.a enterForumTabFeedData;

    public TabFeedListHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_TAB_FEED_LIST);
    }

    public Object getExtra() {
        return this.enterForumTabFeedData.c();
    }

    public ArrayList<n> getThreadList() {
        return this.enterForumTabFeedData.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        String str;
        Integer num;
        TabfeedlistResIdl tabfeedlistResIdl = (TabfeedlistResIdl) new Wire(new Class[0]).parseFrom(bArr, TabfeedlistResIdl.class);
        Error error = tabfeedlistResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = tabfeedlistResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(tabfeedlistResIdl.error.usermsg);
        }
        if (getError() == 0 && tabfeedlistResIdl.data != null) {
            d.b.i0.i0.l.d.a aVar = new d.b.i0.i0.l.d.a();
            this.enterForumTabFeedData = aVar;
            aVar.g(tabfeedlistResIdl.data);
        }
    }
}
