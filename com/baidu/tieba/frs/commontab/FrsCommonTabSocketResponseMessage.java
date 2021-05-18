package com.baidu.tieba.frs.commontab;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.k0.q0.l1.d;
import tbclient.Error;
import tbclient.GeneralTabList.GeneralTabListResIdl;
/* loaded from: classes4.dex */
public class FrsCommonTabSocketResponseMessage extends MvcSocketResponsedMessage<d, GeneralTabListResIdl> {
    public FrsCommonTabSocketResponseMessage() {
        super(309622);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Class' to match base method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public Class<GeneralTabListResIdl> getProtobufResponseIdlClass() {
        return GeneralTabListResIdl.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Error error;
        d dVar = new d();
        GeneralTabListResIdl generalTabListResIdl = (GeneralTabListResIdl) new Wire(new Class[0]).parseFrom(bArr, GeneralTabListResIdl.class);
        dVar.a(generalTabListResIdl.data);
        if (generalTabListResIdl != null && (error = generalTabListResIdl.error) != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(generalTabListResIdl.error.usermsg);
        }
        setData(dVar);
    }
}
