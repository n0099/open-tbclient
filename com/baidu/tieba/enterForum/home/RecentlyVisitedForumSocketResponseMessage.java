package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.data.VisitedForumData;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import tbclient.GetHistoryForum.GetHistoryForumResIdl;
import tbclient.HistoryForumInfo;
/* loaded from: classes7.dex */
public class RecentlyVisitedForumSocketResponseMessage extends SocketResponsedMessage {
    private LinkedList<VisitedForumData> mForumData;

    public RecentlyVisitedForumSocketResponseMessage() {
        super(CmdConfigSocket.CMD_GET_HISTORY_FORUM);
    }

    public LinkedList<VisitedForumData> getForumData() {
        return this.mForumData;
    }

    public void setForumData(LinkedList<VisitedForumData> linkedList) {
        this.mForumData = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetHistoryForumResIdl getHistoryForumResIdl = (GetHistoryForumResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHistoryForumResIdl.class);
        if (getHistoryForumResIdl != null) {
            if (getHistoryForumResIdl.error != null && getHistoryForumResIdl.error.errorno != null) {
                setError(getHistoryForumResIdl.error.errorno.intValue());
            }
            if (getHistoryForumResIdl.error != null && getHistoryForumResIdl.error.usermsg != null && getHistoryForumResIdl.error.usermsg.length() > 0) {
                setErrorString(getHistoryForumResIdl.error.usermsg);
            }
            if (getError() == 0 && getHistoryForumResIdl.data != null && getHistoryForumResIdl.data.history_forum != null) {
                this.mForumData = new LinkedList<>();
                for (HistoryForumInfo historyForumInfo : getHistoryForumResIdl.data.history_forum) {
                    VisitedForumData visitedForumData = new VisitedForumData();
                    visitedForumData.a(historyForumInfo);
                    this.mForumData.add(visitedForumData);
                }
            }
        }
    }
}
