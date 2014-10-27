package com.baidu.tieba.game;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.GetGameCenter.DataReq;
import tbclient.GetGameCenter.GetGameCenterReqIdl;
/* loaded from: classes.dex */
public class RequestGameCenterMessage extends TbSocketMessage {
    private static final int PAGE_LENGTH = 20;
    private static final String ST_TYPE = "index_game_ck";
    private int mPageNum;

    public RequestGameCenterMessage() {
        super(303008);
    }

    public int getPageNum() {
        return this.mPageNum;
    }

    public void setPageNum(int i) {
        this.mPageNum = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.page_num = Integer.valueOf(getPageNum());
        builder.res_num = 20;
        builder.st_type = ST_TYPE;
        GetGameCenterReqIdl.Builder builder2 = new GetGameCenterReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
