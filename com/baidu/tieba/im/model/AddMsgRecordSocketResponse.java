package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.AddMsgRecord.AddMsgRecordResIdl;
import tbclient.AddMsgRecord.DataRes;
import tbclient.Error;
/* loaded from: classes3.dex */
public class AddMsgRecordSocketResponse extends SocketResponsedMessage {
    public DataRes mData;

    public AddMsgRecordSocketResponse() {
        super(309265);
    }

    public DataRes getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AddMsgRecordResIdl addMsgRecordResIdl = (AddMsgRecordResIdl) new Wire(new Class[0]).parseFrom(bArr, AddMsgRecordResIdl.class);
        if (addMsgRecordResIdl == null) {
            return;
        }
        Error error = addMsgRecordResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(addMsgRecordResIdl.error.errmsg);
        }
        DataRes dataRes = addMsgRecordResIdl.data;
        if (dataRes == null) {
            return;
        }
        this.mData = dataRes;
    }
}
