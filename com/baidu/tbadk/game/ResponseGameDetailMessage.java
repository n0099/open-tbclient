package com.baidu.tbadk.game;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GameInfo;
import tbclient.GetGameDetail.GetGameDetailResIdl;
import tbclient.GetGameDetail.RankInfo;
/* loaded from: classes8.dex */
public class ResponseGameDetailMessage extends TbSocketReponsedMessage {
    private GameInfo mGameInfo;
    private RankInfo mRankInfo;

    public ResponseGameDetailMessage() {
        super(CmdConfigSocket.CMD_GET_GAME_DETAIL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        if (bArr != null) {
            GetGameDetailResIdl getGameDetailResIdl = (GetGameDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGameDetailResIdl.class);
            setError(getGameDetailResIdl.error.errorno.intValue());
            setErrorString(getGameDetailResIdl.error.usermsg);
            if (getError() == 0) {
                this.mGameInfo = getGameDetailResIdl.data.game_info;
                this.mRankInfo = getGameDetailResIdl.data.rank_info;
            }
        }
    }

    public GameInfo getGameInfo() {
        return this.mGameInfo;
    }

    public RankInfo getRankInfo() {
        return this.mRankInfo;
    }
}
