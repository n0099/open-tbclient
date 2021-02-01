package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.VisitedForumData;
import com.squareup.wire.Wire;
import java.util.HashMap;
import java.util.LinkedList;
import tbclient.GetHistoryForum.GetHistoryForumResIdl;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class RecentlyVisitedForumHttpResponseMessage extends HttpResponsedMessage {
    private LinkedList<VisitedForumData> mForumData;

    public RecentlyVisitedForumHttpResponseMessage() {
        super(1003394);
    }

    public LinkedList<VisitedForumData> getForumData() {
        return this.mForumData;
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
                HashMap hashMap = new HashMap();
                if (!y.isEmpty(getHistoryForumResIdl.data.this_week_forums)) {
                    for (HistoryForumInfo historyForumInfo : getHistoryForumResIdl.data.this_week_forums) {
                        if (historyForumInfo != null && historyForumInfo.forum_id != null) {
                            hashMap.put(historyForumInfo.forum_id, historyForumInfo);
                        }
                    }
                }
                for (HistoryForumInfo historyForumInfo2 : getHistoryForumResIdl.data.history_forum) {
                    if (historyForumInfo2 != null && historyForumInfo2.forum_id != null) {
                        VisitedForumData visitedForumData = new VisitedForumData();
                        visitedForumData.a(historyForumInfo2);
                        visitedForumData.kG(hashMap.containsKey(historyForumInfo2.forum_id));
                        this.mForumData.add(visitedForumData);
                    }
                }
            }
        }
    }
}
