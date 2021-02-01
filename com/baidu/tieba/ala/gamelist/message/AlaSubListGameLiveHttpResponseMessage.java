package com.baidu.tieba.ala.gamelist.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.cb;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import tbclient.LiveLabelInfo;
import tbclient.LiveTabliveSubTab.LiveTabliveSubTabResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes10.dex */
public class AlaSubListGameLiveHttpResponseMessage extends HttpResponsedMessage {
    private LinkedList<LiveLabelInfo> entryList;
    private boolean mHasMore;
    private LinkedList<cb> threadList;

    public AlaSubListGameLiveHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_SUB_LIVE_LIST);
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
                    cb cbVar = new cb();
                    cbVar.a(threadInfo);
                    this.threadList.add(cbVar);
                }
            }
            this.mHasMore = liveTabliveSubTabResIdl.data.has_more.intValue() == 1;
        }
    }

    public LinkedList<cb> getThreadLiveList() {
        return this.threadList;
    }

    public LinkedList<LiveLabelInfo> getEntryList() {
        return this.entryList;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }
}
