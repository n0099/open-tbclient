package com.baidu.tieba.frs.profession.permission;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.ZoneRight.ZoneRightResIdl;
/* loaded from: classes.dex */
public class ProPermissionSocketResponseMessage extends MvcSocketResponsedMessage<b, ZoneRightResIdl> {
    public ProPermissionSocketResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<ZoneRightResIdl> getProtobufResponseIdlClass() {
        return ZoneRightResIdl.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        try {
            b bVar = new b();
            bVar.initByProtobuf((ZoneRightResIdl) new Wire(new Class[0]).parseFrom(bArr, ZoneRightResIdl.class));
            setData(bVar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
