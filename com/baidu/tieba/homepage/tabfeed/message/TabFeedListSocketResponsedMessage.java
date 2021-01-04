package com.baidu.tieba.homepage.tabfeed.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.homepage.tabfeed.data.a;
import com.squareup.wire.Wire;
import tbclient.ActivityPage.ActivityPageResIdl;
/* loaded from: classes2.dex */
public class TabFeedListSocketResponsedMessage extends TbSocketReponsedMessage {
    public a tabFeedData;

    public TabFeedListSocketResponsedMessage() {
        super(309655);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ActivityPageResIdl activityPageResIdl = (ActivityPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ActivityPageResIdl.class);
        if (activityPageResIdl.error != null && activityPageResIdl.error.errorno != null) {
            setError(activityPageResIdl.error.errorno.intValue());
        }
        if (activityPageResIdl.error != null && activityPageResIdl.error.usermsg != null && activityPageResIdl.error.usermsg.length() > 0) {
            setErrorString(activityPageResIdl.error.usermsg);
        }
        if (getError() == 0 && activityPageResIdl.data != null) {
            this.tabFeedData = new a();
            this.tabFeedData.a(activityPageResIdl.data);
        }
    }
}
