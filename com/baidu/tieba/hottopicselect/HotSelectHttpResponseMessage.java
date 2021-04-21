package com.baidu.tieba.hottopicselect;

import GetSugTopic.DataRes;
import GetSugTopic.GetSugTopicResIdl;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.r.r.a;
import d.b.j0.d1.c;
import tbclient.Error;
/* loaded from: classes4.dex */
public class HotSelectHttpResponseMessage extends TbHttpResponsedMessage {
    public c mBangTopic;
    public c mSugTopic;
    public c mUserHisTopic;

    public HotSelectHttpResponseMessage(int i) {
        super(i);
    }

    public c getBangTopic() {
        return this.mBangTopic;
    }

    public c getSugTopic() {
        return this.mSugTopic;
    }

    public c getUserHisTopic() {
        return this.mUserHisTopic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (bArr == null || bArr.length <= 0 || getError() != 0) {
            return;
        }
        a.f().e("topic_select_space", TbadkCoreApplication.getCurrentAccount()).a("topic_select_user", bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetSugTopicResIdl getSugTopicResIdl = (GetSugTopicResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSugTopicResIdl.class);
        if (getSugTopicResIdl == null) {
            return;
        }
        Error error = getSugTopicResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getSugTopicResIdl.error.errmsg);
        }
        DataRes dataRes = getSugTopicResIdl.data;
        if (dataRes == null) {
            return;
        }
        if (dataRes.user_his_topic != null) {
            c cVar = new c();
            cVar.d(getSugTopicResIdl.data.user_his_topic);
            cVar.f(0);
            this.mUserHisTopic = cVar;
        }
        if (getSugTopicResIdl.data.bang_topic != null) {
            c cVar2 = new c();
            cVar2.f(1);
            cVar2.d(getSugTopicResIdl.data.bang_topic);
            this.mBangTopic = cVar2;
        }
        if (getSugTopicResIdl.data.sug_topic != null) {
            c cVar3 = new c();
            cVar3.d(getSugTopicResIdl.data.sug_topic);
            this.mSugTopic = cVar3;
        }
    }
}
