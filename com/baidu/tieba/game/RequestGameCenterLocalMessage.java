package com.baidu.tieba.game;

import com.baidu.adp.framework.message.CustomMessage;
import tbclient.GetGameCenter.DataReq;
import tbclient.GetGameCenter.GetGameCenterReqIdl;
/* loaded from: classes.dex */
public class RequestGameCenterLocalMessage extends CustomMessage<Object> {
    private static final int PAGE_LENGTH = 20;
    private int mPageNum;

    public RequestGameCenterLocalMessage() {
        super(2001224);
    }

    public int getPageNum() {
        return this.mPageNum;
    }

    public void setPageNum(int i) {
        this.mPageNum = i;
    }

    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.page_num = Integer.valueOf(getPageNum());
        builder.res_num = 20;
        GetGameCenterReqIdl.Builder builder2 = new GetGameCenterReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
