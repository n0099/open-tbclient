package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.VisitedForumData;
import com.squareup.wire.Wire;
import java.util.HashMap;
import java.util.LinkedList;
import tbclient.Error;
import tbclient.GetHistoryForum.DataRes;
import tbclient.GetHistoryForum.GetHistoryForumResIdl;
import tbclient.HistoryForumInfo;
/* loaded from: classes4.dex */
public class RecentlyVisitedForumSocketResponseMessage extends SocketResponsedMessage {
    public LinkedList<VisitedForumData> mForumData;

    public RecentlyVisitedForumSocketResponseMessage() {
        super(309601);
    }

    public LinkedList<VisitedForumData> getForumData() {
        return this.mForumData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        Long l;
        String str;
        Integer num;
        GetHistoryForumResIdl getHistoryForumResIdl = (GetHistoryForumResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHistoryForumResIdl.class);
        if (getHistoryForumResIdl == null) {
            return;
        }
        Error error = getHistoryForumResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = getHistoryForumResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(getHistoryForumResIdl.error.usermsg);
        }
        if (getError() != 0 || (dataRes = getHistoryForumResIdl.data) == null || dataRes.history_forum == null) {
            return;
        }
        this.mForumData = new LinkedList<>();
        HashMap hashMap = new HashMap();
        if (!ListUtils.isEmpty(getHistoryForumResIdl.data.this_week_forums)) {
            for (HistoryForumInfo historyForumInfo : getHistoryForumResIdl.data.this_week_forums) {
                if (historyForumInfo != null && (l = historyForumInfo.forum_id) != null) {
                    hashMap.put(l, historyForumInfo);
                }
            }
        }
        for (HistoryForumInfo historyForumInfo2 : getHistoryForumResIdl.data.history_forum) {
            if (historyForumInfo2 != null && historyForumInfo2.forum_id != null) {
                VisitedForumData visitedForumData = new VisitedForumData();
                visitedForumData.E(historyForumInfo2);
                visitedForumData.F(hashMap.containsKey(historyForumInfo2.forum_id));
                this.mForumData.add(visitedForumData);
            }
        }
    }
}
