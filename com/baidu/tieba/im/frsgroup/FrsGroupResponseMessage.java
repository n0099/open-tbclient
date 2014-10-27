package com.baidu.tieba.im.frsgroup;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import protobuf.QueryGroupsByFid.QueryGroupsByFidResIdl;
/* loaded from: classes.dex */
public class FrsGroupResponseMessage extends MvcSocketResponsedMessage<k, QueryGroupsByFidResIdl> {
    public FrsGroupResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<QueryGroupsByFidResIdl> getProtobufResponseIdlClass() {
        return QueryGroupsByFidResIdl.class;
    }
}
