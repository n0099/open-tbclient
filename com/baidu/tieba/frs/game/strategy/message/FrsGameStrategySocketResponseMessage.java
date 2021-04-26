package com.baidu.tieba.frs.game.strategy.message;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.c.j.e.n;
import d.a.j0.q0.s1.a.c.a;
import d.a.j0.q0.s1.a.d.e;
import java.util.List;
import tbclient.Error;
import tbclient.GameForumGuideTab.GameForumGuideTabResIdl;
/* loaded from: classes4.dex */
public class FrsGameStrategySocketResponseMessage extends SocketResponsedMessage {
    public boolean mHasMore;
    public List<e> mTabList;
    public List<n> mThreadList;

    public FrsGameStrategySocketResponseMessage() {
        super(309478);
        this.mHasMore = false;
    }

    public List<e> getTabList() {
        return this.mTabList;
    }

    public List<n> getThreadList() {
        return this.mThreadList;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        Message<?> orginalMessage = getOrginalMessage();
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = (orginalMessage == null || !(orginalMessage.getExtra() instanceof FrsGameStrategyRequestMessage)) ? null : (FrsGameStrategyRequestMessage) orginalMessage.getExtra();
        if (frsGameStrategyRequestMessage != null) {
            new a().d(String.valueOf(frsGameStrategyRequestMessage.getFid()), bArr, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GameForumGuideTabResIdl gameForumGuideTabResIdl = (GameForumGuideTabResIdl) new Wire(new Class[0]).parseFrom(bArr, GameForumGuideTabResIdl.class);
        if (gameForumGuideTabResIdl == null) {
            return;
        }
        Error error = gameForumGuideTabResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(gameForumGuideTabResIdl.error.errmsg);
        }
        this.mTabList = d.a.j0.q0.s1.a.b.a.a(gameForumGuideTabResIdl.data.sub_tab_list);
        this.mThreadList = d.a.j0.q0.s1.a.b.a.b(gameForumGuideTabResIdl.data.thread_list);
        this.mHasMore = gameForumGuideTabResIdl.data.has_more.intValue() == 1;
    }
}
