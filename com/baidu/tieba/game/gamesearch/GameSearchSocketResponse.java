package com.baidu.tieba.game.gamesearch;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SearchGame.SearchGameResIdl;
/* loaded from: classes.dex */
public class GameSearchSocketResponse extends SocketResponsedMessage {
    private l mData;

    public GameSearchSocketResponse() {
        super(303019);
    }

    public l getGameSearchData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        SearchGameResIdl searchGameResIdl = (SearchGameResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchGameResIdl.class);
        if (searchGameResIdl != null) {
            if (searchGameResIdl.error != null) {
                setError(searchGameResIdl.error.errorno.intValue());
                setErrorString(searchGameResIdl.error.errmsg);
            }
            if (searchGameResIdl.data != null) {
                this.mData = new l();
                this.mData.a(searchGameResIdl.data);
            }
        }
    }
}
