package com.baidu.tieba.game;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetGameCenter.AdList;
import tbclient.GetGameCenter.GameList;
import tbclient.GetGameCenter.GetGameCenterResIdl;
/* loaded from: classes.dex */
public class ResponseGameCenterLocalMessage extends CustomResponsedMessage<Object> {
    private List<AdList> mAdList;
    private GameList mGameList;

    public ResponseGameCenterLocalMessage() {
        super(2001224);
    }

    public GameList getGameList() {
        return this.mGameList;
    }

    public List<AdList> getAdList() {
        return this.mAdList;
    }

    public void decodeInBackGround(int i, byte[] bArr) {
        if (bArr != null) {
            GetGameCenterResIdl getGameCenterResIdl = (GetGameCenterResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGameCenterResIdl.class);
            setError(getGameCenterResIdl.error.errorno.intValue());
            setErrorString(getGameCenterResIdl.error.usermsg);
            if (getError() == 0) {
                this.mGameList = getGameCenterResIdl.data.game_list;
                this.mAdList = getGameCenterResIdl.data.ad_list;
            }
        }
    }
}
