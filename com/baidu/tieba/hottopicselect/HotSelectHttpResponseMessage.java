package com.baidu.tieba.hottopicselect;

import GetSugTopic.GetSugTopicResIdl;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
/* loaded from: classes20.dex */
public class HotSelectHttpResponseMessage extends TbHttpResponsedMessage {
    private c mBangTopic;
    private c mSugTopic;
    private c mUserHisTopic;

    public HotSelectHttpResponseMessage(int i) {
        super(i);
    }

    public c getUserHisTopic() {
        return this.mUserHisTopic;
    }

    public c getBangTopic() {
        return this.mBangTopic;
    }

    public c getSugTopic() {
        return this.mSugTopic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetSugTopicResIdl getSugTopicResIdl = (GetSugTopicResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSugTopicResIdl.class);
        if (getSugTopicResIdl != null) {
            if (getSugTopicResIdl.error != null) {
                setError(getSugTopicResIdl.error.errorno.intValue());
                setErrorString(getSugTopicResIdl.error.errmsg);
            }
            if (getSugTopicResIdl.data != null) {
                if (getSugTopicResIdl.data.user_his_topic != null) {
                    c cVar = new c();
                    cVar.a(getSugTopicResIdl.data.user_his_topic);
                    cVar.setType(0);
                    this.mUserHisTopic = cVar;
                }
                if (getSugTopicResIdl.data.bang_topic != null) {
                    c cVar2 = new c();
                    cVar2.setType(1);
                    cVar2.a(getSugTopicResIdl.data.bang_topic);
                    this.mBangTopic = cVar2;
                }
                if (getSugTopicResIdl.data.sug_topic != null) {
                    c cVar3 = new c();
                    cVar3.a(getSugTopicResIdl.data.sug_topic);
                    this.mSugTopic = cVar3;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (bArr != null && bArr.length > 0 && getError() == 0) {
            com.baidu.tbadk.core.c.a.bob().dF("topic_select_space", TbadkCoreApplication.getCurrentAccount()).asyncSetForever("topic_select_user", bArr);
        }
    }
}
