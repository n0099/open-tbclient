package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.t;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.GetHistoryForum.DataReq;
import tbclient.GetHistoryForum.GetHistoryForumReqIdl;
/* loaded from: classes.dex */
public class RecentlyVisitedForumRequestMessage extends NetMessage {
    private LinkedList<VisitedForumData> mForumData;

    public RecentlyVisitedForumRequestMessage() {
        super(1003394, CmdConfigSocket.CMD_GET_HISTORY_FORUM);
    }

    public LinkedList<VisitedForumData> getForumData() {
        return this.mForumData;
    }

    public void setForumData(LinkedList<VisitedForumData> linkedList) {
        this.mForumData = linkedList;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            JSONArray jSONArray = new JSONArray();
            if (this.mForumData != null) {
                Iterator<VisitedForumData> it = this.mForumData.iterator();
                while (it.hasNext()) {
                    VisitedForumData next = it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("forum_id", com.baidu.adp.lib.f.b.toLong(next.getForumId(), 0L));
                    jSONObject.put("visit_time", next.bAu());
                    jSONArray.put(jSONObject);
                }
            }
            builder.history = jSONArray.toString();
            if (z) {
                t.b(builder, true);
            }
            GetHistoryForumReqIdl.Builder builder2 = new GetHistoryForumReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
