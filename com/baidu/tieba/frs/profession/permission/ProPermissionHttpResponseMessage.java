package com.baidu.tieba.frs.profession.permission;

import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.j0.q0.f2.a.b;
import java.io.IOException;
import tbclient.ZoneRight.ZoneRightResIdl;
/* loaded from: classes4.dex */
public class ProPermissionHttpResponseMessage extends MvcProtobufHttpResponsedMessage<b, ZoneRightResIdl> {
    public ProPermissionHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public Class<ZoneRightResIdl> getProtobufResponseIdlClass() {
        return ZoneRightResIdl.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage, com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        try {
            b bVar = new b();
            bVar.initByProtobuf((ZoneRightResIdl) new Wire(new Class[0]).parseFrom(bArr, ZoneRightResIdl.class));
            setData(bVar);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
