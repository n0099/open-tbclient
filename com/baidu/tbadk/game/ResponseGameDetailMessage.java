package com.baidu.tbadk.game;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GameInfo;
import tbclient.GetGameDetail.DataRes;
import tbclient.GetGameDetail.GetGameDetailResIdl;
import tbclient.GetGameDetail.RankInfo;
/* loaded from: classes3.dex */
public class ResponseGameDetailMessage extends TbSocketReponsedMessage {
    public GameInfo mGameInfo;
    public RankInfo mRankInfo;

    public ResponseGameDetailMessage() {
        super(303009);
    }

    public GameInfo getGameInfo() {
        return this.mGameInfo;
    }

    public RankInfo getRankInfo() {
        return this.mRankInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        if (bArr == null) {
            return;
        }
        GetGameDetailResIdl getGameDetailResIdl = (GetGameDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGameDetailResIdl.class);
        setError(getGameDetailResIdl.error.errorno.intValue());
        setErrorString(getGameDetailResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        DataRes dataRes = getGameDetailResIdl.data;
        this.mGameInfo = dataRes.game_info;
        this.mRankInfo = dataRes.rank_info;
    }
}
