package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.AddMsgRecord.AddMsgRecordResIdl;
import tbclient.AddMsgRecord.DataRes;
import tbclient.Error;
/* loaded from: classes4.dex */
public class AddMsgRecordHttpProtoResponse extends HttpResponsedMessage {
    public DataRes mData;

    public AddMsgRecordHttpProtoResponse() {
        super(CmdConfigHttp.CMD_ADD_MSG_RECORD);
    }

    public DataRes getData() {
        return this.mData;
    }

    public AddMsgRecordHttpProtoResponse(int i) {
        super(CmdConfigHttp.CMD_ADD_MSG_RECORD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
