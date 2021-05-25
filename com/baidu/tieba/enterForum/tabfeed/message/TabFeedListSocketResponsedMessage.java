package com.baidu.tieba.enterForum.tabfeed.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import d.a.c.j.e.n;
import d.a.m0.g0.b.a;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.Tabfeedlist.TabfeedlistResIdl;
/* loaded from: classes4.dex */
public class TabFeedListSocketResponsedMessage extends TbSocketReponsedMessage implements a {
    public d.a.n0.j0.l.d.a enterForumTabFeedData;

    public TabFeedListSocketResponsedMessage() {
        super(309651);
    }

    public Object getExtra() {
        return this.enterForumTabFeedData.c();
    }

    public ArrayList<n> getThreadList() {
        return this.enterForumTabFeedData.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
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
            d.a.n0.j0.l.d.a aVar = new d.a.n0.j0.l.d.a();
            this.enterForumTabFeedData = aVar;
            aVar.g(tabfeedlistResIdl.data);
        }
    }
}
