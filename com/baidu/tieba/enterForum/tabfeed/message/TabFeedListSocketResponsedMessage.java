package com.baidu.tieba.enterForum.tabfeed.message;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tbadk.mvc.b.k;
import com.baidu.tieba.enterForum.tabfeed.b.a;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.Tabfeedlist.TabfeedlistResIdl;
/* loaded from: classes2.dex */
public class TabFeedListSocketResponsedMessage extends TbSocketReponsedMessage implements k {
    public a enterForumTabFeedData;

    public TabFeedListSocketResponsedMessage() {
        super(309651);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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

    public ArrayList<n> getThreadList() {
        return this.enterForumTabFeedData.czH();
    }

    public Object getExtra() {
        return this.enterForumTabFeedData.czJ();
    }
}
