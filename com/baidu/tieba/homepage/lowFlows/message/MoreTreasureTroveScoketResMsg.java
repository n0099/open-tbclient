package com.baidu.tieba.homepage.lowFlows.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.homepage.lowFlows.d.c;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.MoreTreasureTrove.MoreTreasureTroveResIdl;
/* loaded from: classes2.dex */
public class MoreTreasureTroveScoketResMsg extends SocketResponsedMessage implements a {
    private List<n> mMoreTreasureTroveDataList;

    public MoreTreasureTroveScoketResMsg() {
        super(309691);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        MoreTreasureTroveResIdl moreTreasureTroveResIdl;
        if (bArr != null && (moreTreasureTroveResIdl = (MoreTreasureTroveResIdl) new Wire(new Class[0]).parseFrom(bArr, MoreTreasureTroveResIdl.class)) != null) {
            if (moreTreasureTroveResIdl.error != null) {
                setError(moreTreasureTroveResIdl.error.errorno.intValue());
                setErrorString(moreTreasureTroveResIdl.error.usermsg);
            }
            this.mMoreTreasureTroveDataList = c.a(moreTreasureTroveResIdl);
        }
    }

    @Override // com.baidu.tieba.homepage.lowFlows.message.a
    public List<n> getDataList() {
        return this.mMoreTreasureTroveDataList;
    }
}
