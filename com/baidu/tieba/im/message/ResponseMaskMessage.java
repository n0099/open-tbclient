package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.MaskData;
import com.squareup.wire.Wire;
import protobuf.GetMaskInfo.DataRes;
import protobuf.GetMaskInfo.GetMaskInfoResIdl;
/* loaded from: classes.dex */
public class ResponseMaskMessage extends SocketResponsedMessage {
    private MaskData maskData;

    public ResponseMaskMessage() {
        super(104103);
    }

    public MaskData getMaskData() {
        return this.maskData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetMaskInfoResIdl getMaskInfoResIdl = (GetMaskInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMaskInfoResIdl.class);
        setError(getMaskInfoResIdl.error.errorno.intValue());
        setErrorString(getMaskInfoResIdl.error.usermsg);
        if (getError() == 0) {
            DataRes dataRes = getMaskInfoResIdl.data;
            this.maskData = new MaskData();
            this.maskData.setIsMask(dataRes.isMask.intValue());
            this.maskData.setList(this.maskData.getList());
        }
    }
}
