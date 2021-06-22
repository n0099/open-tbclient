package com.baidu.tieba.homepage.lowFlows.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import d.a.c.k.e.n;
import d.a.o0.b1.g.e.a;
import d.a.o0.b1.g.h.c;
import java.util.List;
import tbclient.Error;
import tbclient.MoreTreasureTrove.MoreTreasureTroveResIdl;
/* loaded from: classes4.dex */
public class MoreTreasureTroveHttpResMsg extends HttpResponsedMessage implements a {
    public List<n> mMoreTreasureTroveDataList;

    public MoreTreasureTroveHttpResMsg() {
        super(CmdConfigHttp.CMD_LOW_FLOWS_PAGE);
    }

    @Override // d.a.o0.b1.g.e.a
    public List<n> getDataList() {
        return this.mMoreTreasureTroveDataList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        MoreTreasureTroveResIdl moreTreasureTroveResIdl;
        if (bArr == null || (moreTreasureTroveResIdl = (MoreTreasureTroveResIdl) new Wire(new Class[0]).parseFrom(bArr, MoreTreasureTroveResIdl.class)) == null) {
            return;
        }
        Error error = moreTreasureTroveResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(moreTreasureTroveResIdl.error.usermsg);
        }
        this.mMoreTreasureTroveDataList = c.b(moreTreasureTroveResIdl);
    }
}
