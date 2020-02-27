package com.baidu.tieba.frs.game.strategy.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GameForumGuideTab.DataReq;
import tbclient.GameForumGuideTab.GameForumGuideTabReqIdl;
/* loaded from: classes9.dex */
public class FrsGameStrategyRequestMessage extends NetMessage {
    private long mFid;
    private int mLabelId;
    private int mPn;
    private int mTabId;

    public FrsGameStrategyRequestMessage(long j, int i, int i2, int i3) {
        super(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY);
        this.mPn = 0;
        this.mFid = j;
        this.mPn = i;
        this.mTabId = i2;
        this.mLabelId = i3;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mFid);
        builder.need_tab_stuct = Integer.valueOf((this.mTabId == 0 && this.mLabelId == 0) ? 1 : 0);
        builder.sub_tab_id = Integer.valueOf(this.mTabId);
        builder.sub_label_id = Integer.valueOf(this.mLabelId);
        builder.pn = Integer.valueOf(this.mPn);
        if (z) {
            t.a(builder, true);
        }
        GameForumGuideTabReqIdl.Builder builder2 = new GameForumGuideTabReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getFid() {
        return this.mFid;
    }
}
