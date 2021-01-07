package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.PersonalizedResIdl;
/* loaded from: classes2.dex */
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
            i.khT = false;
            if (i.g(this) && personalizedResIdl.data != null && personalizedResIdl.data.thread_list != null && personalizedResIdl.data.thread_list.size() == 0) {
                this.resultData = i.cTx();
                i.khT = true;
                i.cTy();
                return;
            }
            this.resultData = personalizedResIdl.data;
        }
    }
}
