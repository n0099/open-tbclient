package com.baidu.tieba.frs.commontab;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GeneralTabList.GeneralTabListResIdl;
/* loaded from: classes16.dex */
public class FrsCommonTabSocketResponseMessage extends MvcSocketResponsedMessage<d, GeneralTabListResIdl> {
    public FrsCommonTabSocketResponseMessage() {
        super(309622);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Class' to match base method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<GeneralTabListResIdl> getProtobufResponseIdlClass() {
        return GeneralTabListResIdl.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        d dVar = new d();
        GeneralTabListResIdl generalTabListResIdl = (GeneralTabListResIdl) new Wire(new Class[0]).parseFrom(bArr, GeneralTabListResIdl.class);
        dVar.a(generalTabListResIdl.data);
        if (generalTabListResIdl != null && generalTabListResIdl.error != null) {
            if (generalTabListResIdl.error.errorno != null) {
                setError(generalTabListResIdl.error.errorno.intValue());
            }
            setErrorString(generalTabListResIdl.error.usermsg);
        }
        setData(dVar);
    }
}
