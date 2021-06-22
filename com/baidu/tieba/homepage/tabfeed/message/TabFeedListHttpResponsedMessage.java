package com.baidu.tieba.homepage.tabfeed.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.o0.b1.j.h.a;
import tbclient.ActivityPage.ActivityPageResIdl;
import tbclient.Error;
/* loaded from: classes4.dex */
public class TabFeedListHttpResponsedMessage extends TbHttpResponsedMessage {
    public a tabFeedData;

    public TabFeedListHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        String str;
        Integer num;
        ActivityPageResIdl activityPageResIdl = (ActivityPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ActivityPageResIdl.class);
        Error error = activityPageResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = activityPageResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(activityPageResIdl.error.usermsg);
        }
        if (getError() == 0 && activityPageResIdl.data != null) {
            a aVar = new a();
            this.tabFeedData = aVar;
            aVar.j(activityPageResIdl.data);
        }
    }
}
