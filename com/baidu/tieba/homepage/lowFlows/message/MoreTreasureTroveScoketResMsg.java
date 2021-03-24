package com.baidu.tieba.homepage.lowFlows.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.b.j.e.n;
import d.b.i0.z0.f.e.a;
import d.b.i0.z0.f.h.c;
import java.util.List;
import tbclient.Error;
import tbclient.MoreTreasureTrove.MoreTreasureTroveResIdl;
/* loaded from: classes4.dex */
public class MoreTreasureTroveScoketResMsg extends SocketResponsedMessage implements a {
    public List<n> mMoreTreasureTroveDataList;

    public MoreTreasureTroveScoketResMsg() {
        super(309691);
    }

    @Override // d.b.i0.z0.f.e.a
    public List<n> getDataList() {
        return this.mMoreTreasureTroveDataList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
