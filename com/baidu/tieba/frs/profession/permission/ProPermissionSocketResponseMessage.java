package com.baidu.tieba.frs.profession.permission;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.o0.r0.f2.a.b;
import java.io.IOException;
import tbclient.ZoneRight.ZoneRightResIdl;
/* loaded from: classes4.dex */
public class ProPermissionSocketResponseMessage extends MvcSocketResponsedMessage<b, ZoneRightResIdl> {
    public ProPermissionSocketResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public Class<ZoneRightResIdl> getProtobufResponseIdlClass() {
        return ZoneRightResIdl.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        super.decodeInBackGround(i2, bArr);
        try {
            b bVar = new b();
            bVar.initByProtobuf((ZoneRightResIdl) new Wire(new Class[0]).parseFrom(bArr, ZoneRightResIdl.class));
            setData(bVar);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
