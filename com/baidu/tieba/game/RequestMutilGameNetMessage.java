package com.baidu.tieba.game;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetMutilGameList.DataReq;
import tbclient.GetMutilGameList.GetMutilGameListReqIdl;
/* loaded from: classes.dex */
public class RequestMutilGameNetMessage extends NetMessage {
    public static final int TYPE_NEW_GAME = 2;
    public static final int TYPE_RECOMMEND_GAME = 1;
    private int mPageLength;
    private int mPageNum;
    private int mType;

    public RequestMutilGameNetMessage() {
        super(CmdConfigHttp.CMD_GET_MUTIL_GAME_LIST, 303015);
        this.mPageLength = 20;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }

    public void setPageNum(int i) {
        this.mPageNum = i;
    }

    public int getPageNum() {
        return this.mPageNum;
    }

    public void setmPageLength(int i) {
        this.mPageLength = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.type = Integer.valueOf(this.mType);
        builder.pn = Integer.valueOf(this.mPageNum);
        builder.rn = Integer.valueOf(this.mPageLength);
        if (z) {
            com.baidu.tbadk.util.g.a(builder, true);
        }
        GetMutilGameListReqIdl.Builder builder2 = new GetMutilGameListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
