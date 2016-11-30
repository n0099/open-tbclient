package com.baidu.tieba.acrossForum.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Acrossforum.AcrossforumResIdl;
import tbclient.Acrossforum.DataRes;
/* loaded from: classes.dex */
public class AcrossForumHttpResMsg extends HttpResponsedMessage {
    public DataRes result;

    public AcrossForumHttpResMsg() {
        super(CmdConfigHttp.CMD_ACROSS_FORUM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AcrossforumResIdl acrossforumResIdl = (AcrossforumResIdl) new Wire(new Class[0]).parseFrom(bArr, AcrossforumResIdl.class);
        if (acrossforumResIdl != null) {
            if (acrossforumResIdl.error != null) {
                setError(acrossforumResIdl.error.errorno.intValue());
                setErrorString(acrossforumResIdl.error.usermsg);
            }
            if (getError() == 0) {
                this.result = acrossforumResIdl.data;
            }
        }
    }
}
