package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.AddMsgRecord.AddMsgRecordResIdl;
import tbclient.AddMsgRecord.DataRes;
/* loaded from: classes2.dex */
public class AddMsgRecordHttpProtoResponse extends HttpResponsedMessage {
    private DataRes mData;

    public AddMsgRecordHttpProtoResponse() {
        super(1003071);
    }

    public AddMsgRecordHttpProtoResponse(int i) {
        super(1003071);
    }

    public DataRes getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AddMsgRecordResIdl addMsgRecordResIdl = (AddMsgRecordResIdl) new Wire(new Class[0]).parseFrom(bArr, AddMsgRecordResIdl.class);
        if (addMsgRecordResIdl != null) {
            if (addMsgRecordResIdl.error != null) {
                setError(addMsgRecordResIdl.error.errorno.intValue());
                setErrorString(addMsgRecordResIdl.error.errmsg);
            }
            if (addMsgRecordResIdl.data != null) {
                this.mData = addMsgRecordResIdl.data;
            }
        }
    }
}
