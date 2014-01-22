package com.baidu.tieba.im.message;

import com.baidu.tieba.data.MaskData;
import java.util.LinkedList;
import protobuf.GetMaskInfo.GetMaskInfoRes;
/* loaded from: classes.dex */
public class bv extends cr implements com.baidu.tieba.im.coder.f {
    private MaskData a;

    public void a(MaskData maskData) {
        this.a = maskData;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        GetMaskInfoRes.GetMaskInfoResIdl parseFrom = GetMaskInfoRes.GetMaskInfoResIdl.parseFrom(bArr);
        e(i);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!k()) {
            GetMaskInfoRes.DataRes data = parseFrom.getData();
            MaskData maskData = new MaskData();
            maskData.setIsMask(data.getIsMask());
            maskData.setList(maskData.getList());
            a(maskData);
        }
    }
}
