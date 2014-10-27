package com.baidu.tbadk.game;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GameInfo;
import tbclient.GetGameDetail.GetGameDetailResIdl;
import tbclient.GetGameDetail.RankInfo;
/* loaded from: classes.dex */
public class ResponseGameDetailMessage extends TbSocketReponsedMessage {
    private GameInfo mGameInfo;
    private RankInfo mRankInfo;

    public ResponseGameDetailMessage() {
        super(303009);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
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
