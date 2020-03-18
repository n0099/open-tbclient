package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.PersonalizedResIdl;
/* loaded from: classes9.dex */
public class RecPersonalizeHttpResponse extends HttpResponsedMessage {
    private DataRes resultData;

    public RecPersonalizeHttpResponse(int i) {
        super(1003070);
    }

    public DataRes getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PersonalizedResIdl personalizedResIdl = (PersonalizedResIdl) new Wire(new Class[0]).parseFrom(bArr, PersonalizedResIdl.class);
        if (personalizedResIdl != null) {
            if (personalizedResIdl.error != null) {
                if (personalizedResIdl.error.errorno != null) {
                    setError(personalizedResIdl.error.errorno.intValue());
                }
                setErrorString(personalizedResIdl.error.usermsg);
            }
            h.hgF = false;
            if (h.g(this) && personalizedResIdl.data != null && personalizedResIdl.data.thread_list != null && personalizedResIdl.data.thread_list.size() == 0) {
                this.resultData = h.bPw();
                h.hgF = true;
                h.bPx();
                return;
            }
            this.resultData = personalizedResIdl.data;
        }
    }
}
