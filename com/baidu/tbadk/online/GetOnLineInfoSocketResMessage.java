package com.baidu.tbadk.online;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.GetOnlineInfo.Game;
import protobuf.GetOnlineInfo.GetOnlineInfoResIdl;
import protobuf.GetOnlineInfo.Gift;
/* loaded from: classes.dex */
public class GetOnLineInfoSocketResMessage extends SocketResponsedMessage {
    private Game game;
    private Gift gift;

    public GetOnLineInfoSocketResMessage() {
        super(205005);
    }

    public Game getGame() {
        return this.game;
    }

    public Gift getGift() {
        return this.gift;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetOnlineInfoResIdl getOnlineInfoResIdl = (GetOnlineInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetOnlineInfoResIdl.class);
        setError(getOnlineInfoResIdl.error.errorno.intValue());
        setErrorString(getOnlineInfoResIdl.error.usermsg);
        if (getError() == 0) {
            this.game = getOnlineInfoResIdl.data.game;
            this.gift = getOnlineInfoResIdl.data.gift;
        }
    }
}
