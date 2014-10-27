package com.baidu.tieba.game.gamesearch;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.SearchGame.DataReq;
import tbclient.SearchGame.SearchGameReqIdl;
/* loaded from: classes.dex */
public class GameSearchNetMessage extends NetMessage {
    private Integer pn;
    private String query;
    private Integer rn;

    public GameSearchNetMessage() {
        super(CmdConfigHttp.MSG_GAME_SEARCH_CMD, 303019);
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public String getQuery() {
        return this.query;
    }

    public void setPageNum(Integer num) {
        this.pn = num;
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.query = this.query;
        builder.pn = this.pn;
        builder.rn = this.rn;
        if (z) {
            com.baidu.tbadk.util.g.a(builder, true);
        }
        SearchGameReqIdl.Builder builder2 = new SearchGameReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
