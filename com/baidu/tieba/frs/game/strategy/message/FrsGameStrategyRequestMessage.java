package com.baidu.tieba.frs.game.strategy.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.GameForumGuideTab.DataReq;
import tbclient.GameForumGuideTab.GameForumGuideTabReqIdl;
/* loaded from: classes4.dex */
public class FrsGameStrategyRequestMessage extends NetMessage {
    public long mFid;
    public int mLabelId;
    public int mPn;
    public int mTabId;

    public FrsGameStrategyRequestMessage(long j, int i2, int i3, int i4) {
        super(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.mPn = 0;
        this.mFid = j;
        this.mPn = i2;
        this.mTabId = i3;
        this.mLabelId = i4;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mFid);
        builder.need_tab_stuct = Integer.valueOf((this.mTabId == 0 && this.mLabelId == 0) ? 1 : 0);
        builder.sub_tab_id = Integer.valueOf(this.mTabId);
        builder.sub_label_id = Integer.valueOf(this.mLabelId);
        builder.pn = Integer.valueOf(this.mPn);
        if (z) {
            w.a(builder, true);
        }
        GameForumGuideTabReqIdl.Builder builder2 = new GameForumGuideTabReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getFid() {
        return this.mFid;
    }
}
