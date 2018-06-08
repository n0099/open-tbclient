package com.baidu.tieba.frs.game.strategy.message;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.frs.game.strategy.tab.e;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumGuideTabResIdl;
/* loaded from: classes3.dex */
public class FrsGameStrategySocketResponseMessage extends SocketResponsedMessage {
    private boolean mHasMore;
    private List<e> mTabList;
    private List<h> mThreadList;

    public FrsGameStrategySocketResponseMessage() {
        super(309478);
        this.mHasMore = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GameForumGuideTabResIdl gameForumGuideTabResIdl = (GameForumGuideTabResIdl) new Wire(new Class[0]).parseFrom(bArr, GameForumGuideTabResIdl.class);
        if (gameForumGuideTabResIdl != null) {
            if (gameForumGuideTabResIdl.error != null) {
                setError(gameForumGuideTabResIdl.error.errorno.intValue());
                setErrorString(gameForumGuideTabResIdl.error.errmsg);
            }
            this.mTabList = a.bp(gameForumGuideTabResIdl.data.sub_tab_list);
            this.mThreadList = a.bq(gameForumGuideTabResIdl.data.thread_list);
            this.mHasMore = gameForumGuideTabResIdl.data.has_more.intValue() == 1;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Message<?> orginalMessage = getOrginalMessage();
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = null;
        if (orginalMessage != null && (orginalMessage.getExtra() instanceof FrsGameStrategyRequestMessage)) {
            frsGameStrategyRequestMessage = (FrsGameStrategyRequestMessage) orginalMessage.getExtra();
        }
        if (frsGameStrategyRequestMessage != null) {
            new com.baidu.tieba.frs.game.strategy.a.a().b(String.valueOf(frsGameStrategyRequestMessage.getFid()), bArr, false);
        }
    }

    public List<e> getTabList() {
        return this.mTabList;
    }

    public List<h> getThreadList() {
        return this.mThreadList;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }
}
