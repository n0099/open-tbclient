package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import d.a.o0.b1.h.j.i;
import java.util.List;
import tbclient.Error;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.PersonalizedResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class RecPersonalizeHttpResponse extends HttpResponsedMessage {
    public DataRes resultData;

    public RecPersonalizeHttpResponse(int i2) {
        super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE);
    }

    public DataRes getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        List<ThreadInfo> list;
        PersonalizedResIdl personalizedResIdl = (PersonalizedResIdl) new Wire(new Class[0]).parseFrom(bArr, PersonalizedResIdl.class);
        if (personalizedResIdl == null) {
            return;
        }
        Error error = personalizedResIdl.error;
        if (error != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(personalizedResIdl.error.usermsg);
        }
        i.f55626a = false;
        if (i.c(this) && (dataRes = personalizedResIdl.data) != null && (list = dataRes.thread_list) != null && list.size() == 0) {
            this.resultData = i.b();
            i.f55626a = true;
            i.a();
            return;
        }
        this.resultData = personalizedResIdl.data;
    }
}
