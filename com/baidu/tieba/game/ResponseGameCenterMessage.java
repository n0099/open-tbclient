package com.baidu.tieba.game;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetGameCenter.AdList;
import tbclient.GetGameCenter.GameList;
import tbclient.GetGameCenter.GetGameCenterResIdl;
/* loaded from: classes.dex */
public class ResponseGameCenterMessage extends TbSocketReponsedMessage {
    private List<AdList> mAdList;
    private GameList mGameList;

    public ResponseGameCenterMessage() {
        super(303008);
    }

    public GameList getGameList() {
        return this.mGameList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        RequestGameCenterMessage requestGameCenterMessage;
        Message<?> orginalMessage = getOrginalMessage();
        if ((orginalMessage instanceof RequestGameCenterMessage) && getError() == 0 && (requestGameCenterMessage = (RequestGameCenterMessage) orginalMessage) != null && requestGameCenterMessage.getPageNum() == 0) {
            saveProtocolBufferDataToCache(com.baidu.tbadk.core.a.a.a().a("tb.game_center_home"), "game_center_cache", bArr);
        }
    }

    public List<AdList> getAdLists() {
        return this.mAdList;
    }
}
