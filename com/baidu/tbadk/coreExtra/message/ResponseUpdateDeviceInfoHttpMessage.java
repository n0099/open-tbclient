package com.baidu.tbadk.coreExtra.message;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.UpdateDeviceInfo.UpdateDeviceInfoResIdl;
/* loaded from: classes.dex */
public class ResponseUpdateDeviceInfoHttpMessage extends TbHttpResponsedMessage {
    public ResponseUpdateDeviceInfoHttpMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        UpdateDeviceInfoResIdl updateDeviceInfoResIdl = (UpdateDeviceInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateDeviceInfoResIdl.class);
        if (updateDeviceInfoResIdl != null && updateDeviceInfoResIdl.error != null) {
            if (updateDeviceInfoResIdl.error.errorno != null) {
                setError(updateDeviceInfoResIdl.error.errorno.intValue());
            }
            setErrorString(updateDeviceInfoResIdl.error.usermsg);
        }
    }
}
