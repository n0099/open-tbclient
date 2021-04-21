package com.baidu.tieba.ala.gamelist.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.ala.AlaCmdConfigSocket;
import com.squareup.wire.Wire;
import d.b.i0.r.q.a2;
import java.util.LinkedList;
import tbclient.LiveLabelInfo;
import tbclient.LiveTabliveSubTab.LiveTabliveSubTabResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class AlaSubListGameLiveSocketResponseMessage extends SocketResponsedMessage {
    public LinkedList<LiveLabelInfo> entryList;
    public boolean mHasMore;
    public LinkedList<a2> threadList;

    public AlaSubListGameLiveSocketResponseMessage() {
        super(AlaCmdConfigSocket.CMD_ALA_SUB_LIVE_LIST);
    }

    public LinkedList<LiveLabelInfo> getEntryList() {
        return this.entryList;
    }

    public LinkedList<a2> getThreadLiveList() {
        return this.threadList;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        LiveTabliveSubTabResIdl liveTabliveSubTabResIdl = (LiveTabliveSubTabResIdl) new Wire(new Class[0]).parseFrom(bArr, LiveTabliveSubTabResIdl.class);
        setError(liveTabliveSubTabResIdl.error.errorno.intValue());
        setErrorString(liveTabliveSubTabResIdl.error.usermsg);
        if (hasError()) {
            return;
        }
        this.threadList = new LinkedList<>();
        LinkedList<LiveLabelInfo> linkedList = new LinkedList<>();
        this.entryList = linkedList;
        linkedList.addAll(liveTabliveSubTabResIdl.data.label);
        for (ThreadInfo threadInfo : liveTabliveSubTabResIdl.data.live) {
            if (threadInfo.thread_type.intValue() == 49) {
                a2 a2Var = new a2();
                a2Var.R2(threadInfo);
                this.threadList.add(a2Var);
            }
        }
        this.mHasMore = liveTabliveSubTabResIdl.data.has_more.intValue() == 1;
    }
}
