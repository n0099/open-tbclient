package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.MaskData;
import protobuf.GetMaskInfo.GetMaskInfoRes;
/* loaded from: classes.dex */
public class ResponseMaskMessage extends SocketResponsedMessage {
    private MaskData a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        GetMaskInfoRes.GetMaskInfoResIdl parseFrom = GetMaskInfoRes.GetMaskInfoResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            GetMaskInfoRes.DataRes data = parseFrom.getData();
            MaskData maskData = new MaskData();
            maskData.setIsMask(data.getIsMask());
            maskData.setList(maskData.getList());
            this.a = maskData;
        }
    }

    public ResponseMaskMessage() {
        super(104103);
    }
}
