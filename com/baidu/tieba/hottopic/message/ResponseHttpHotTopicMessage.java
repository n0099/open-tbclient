package com.baidu.tieba.hottopic.message;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.hottopic.data.e;
import com.squareup.wire.Wire;
import tbclient.Hottopic.HottopicResIdl;
/* loaded from: classes7.dex */
public class ResponseHttpHotTopicMessage extends TbHttpResponsedMessage {
    private e topicData;

    public ResponseHttpHotTopicMessage() {
        super(1003041);
        this.topicData = null;
    }

    public e getHotTopicData() {
        return this.topicData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Integer num;
        HottopicResIdl hottopicResIdl = (HottopicResIdl) new Wire(new Class[0]).parseFrom(bArr, HottopicResIdl.class);
        if (hottopicResIdl != null) {
            setError(hottopicResIdl.error.errorno.intValue());
            setErrorString(hottopicResIdl.error.usermsg);
            if (getError() == 0) {
                Object extra = getOrginalMessage().getExtra();
                if (!(extra instanceof Integer)) {
                    num = null;
                } else {
                    num = (Integer) extra;
                }
                this.topicData = new e();
                if (num != null) {
                    this.topicData.sortType = num.intValue();
                }
                this.topicData.a(hottopicResIdl.data);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
    }
}
