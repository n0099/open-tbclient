package com.baidu.tbadk.game;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.GetGameDetail.DataReq;
import tbclient.GetGameDetail.GetGameDetailReqIdl;
/* loaded from: classes11.dex */
public class RequestGameDetailMessage extends TbSocketMessage {
    private String mGameId;

    public RequestGameDetailMessage() {
        super(CmdConfigSocket.CMD_GET_GAME_DETAIL);
    }

    public void setGameId(String str) {
        this.mGameId = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.game_id = this.mGameId;
        GetGameDetailReqIdl.Builder builder2 = new GetGameDetailReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
