package com.baidu.tieba.game.hot;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.g;
import tbclient.GetHotGameList.DataReq;
import tbclient.GetHotGameList.GetHotGameListReqIdl;
/* loaded from: classes.dex */
public class HotGameMessage extends NetMessage {
    public HotGameMessage() {
        super(CmdConfigHttp.GET_HOT_GAME_LIST_CMD, 303020);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        g.a(builder, true);
        GetHotGameListReqIdl.Builder builder2 = new GetHotGameListReqIdl.Builder();
        builder.recommend_platform = 2;
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
