package com.baidu.tieba.ala.gamelist.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.tbadk.core.data.bx;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import tbclient.LiveLabelInfo;
import tbclient.LiveTabliveSubTab.LiveTabliveSubTabResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class AlaSubListGameLiveSocketResponseMessage extends SocketResponsedMessage {
    private LinkedList<LiveLabelInfo> entryList;
    private boolean mHasMore;
    private LinkedList<bx> threadList;

    public AlaSubListGameLiveSocketResponseMessage() {
        super(AlaCmdConfigSocket.CMD_ALA_SUB_LIVE_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        LiveTabliveSubTabResIdl liveTabliveSubTabResIdl = (LiveTabliveSubTabResIdl) new Wire(new Class[0]).parseFrom(bArr, LiveTabliveSubTabResIdl.class);
        setError(liveTabliveSubTabResIdl.error.errorno.intValue());
        setErrorString(liveTabliveSubTabResIdl.error.usermsg);
        if (!hasError()) {
            this.threadList = new LinkedList<>();
            this.entryList = new LinkedList<>();
            this.entryList.addAll(liveTabliveSubTabResIdl.data.label);
            for (ThreadInfo threadInfo : liveTabliveSubTabResIdl.data.live) {
                if (threadInfo.thread_type.intValue() == 49) {
                    bx bxVar = new bx();
                    bxVar.a(threadInfo);
                    this.threadList.add(bxVar);
                }
            }
            this.mHasMore = liveTabliveSubTabResIdl.data.has_more.intValue() == 1;
        }
    }

    public LinkedList<bx> getThreadLiveList() {
        return this.threadList;
    }

    public LinkedList<LiveLabelInfo> getEntryList() {
        return this.entryList;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }
}
