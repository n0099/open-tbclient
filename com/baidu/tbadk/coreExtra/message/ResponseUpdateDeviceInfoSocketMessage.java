package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.UpdateDeviceInfo.UpdateDeviceInfoResIdl;
/* loaded from: classes.dex */
public class ResponseUpdateDeviceInfoSocketMessage extends SocketResponsedMessage {
    public ResponseUpdateDeviceInfoSocketMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
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
