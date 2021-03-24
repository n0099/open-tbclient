package com.baidu.tbadk.game;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.GetGameDetail.DataReq;
import tbclient.GetGameDetail.GetGameDetailReqIdl;
/* loaded from: classes3.dex */
public class RequestGameDetailMessage extends TbSocketMessage {
    public String mGameId;

    public RequestGameDetailMessage() {
        super(303009);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.game_id = this.mGameId;
        GetGameDetailReqIdl.Builder builder2 = new GetGameDetailReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setGameId(String str) {
        this.mGameId = str;
    }
}
