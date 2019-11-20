package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.PersonalizedResIdl;
/* loaded from: classes4.dex */
public class RecPersonalizeSocketResponse extends SocketResponsedMessage {
    private DataRes resultData;

    public RecPersonalizeSocketResponse() {
        super(CmdConfigSocket.CMD_RECOMMEND_PERSONALIZED);
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
            h.glV = false;
            if (h.g(this) && personalizedResIdl.data != null && personalizedResIdl.data.thread_list != null && personalizedResIdl.data.thread_list.size() == 0) {
                this.resultData = h.bvg();
                h.glV = true;
                h.bvh();
                return;
            }
            this.resultData = personalizedResIdl.data;
        }
    }
}
