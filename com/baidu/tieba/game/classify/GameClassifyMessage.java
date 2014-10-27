package com.baidu.tieba.game.classify;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.g;
import tbclient.GetGameCategory.DataReq;
import tbclient.GetGameCategory.GetGameCategoryReqIdl;
/* loaded from: classes.dex */
public class GameClassifyMessage extends NetMessage {
    public GameClassifyMessage() {
        super(CmdConfigHttp.MSG_GAME_LIST_TYPE_CMD, 303104);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        g.a(builder, true);
        GetGameCategoryReqIdl.Builder builder2 = new GetGameCategoryReqIdl.Builder();
        builder.recommend_platform = 2;
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
