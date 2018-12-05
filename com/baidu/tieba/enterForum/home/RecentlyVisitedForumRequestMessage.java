package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.p;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.GetHistoryForum.DataReq;
import tbclient.GetHistoryForum.GetHistoryForumReqIdl;
/* loaded from: classes4.dex */
public class RecentlyVisitedForumRequestMessage extends NetMessage {
    private String history_info;
    private LinkedList<VisitedForumData> mForumData;

    public RecentlyVisitedForumRequestMessage() {
        super(CmdConfigHttp.CMD_GET_HISTORY_FORUM, 309601);
    }

    public LinkedList<VisitedForumData> getForumData() {
        return this.mForumData;
    }

    public void setForumData(LinkedList<VisitedForumData> linkedList) {
        this.mForumData = linkedList;
    }

    public String getHistoryInfo() {
        return this.history_info;
    }

    public void setHistoryInfo(String str) {
        this.history_info = str;
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
                    jSONObject.put("forum_id", com.baidu.adp.lib.g.b.d(next.getForumId(), 0L));
                    jSONObject.put("visit_time", next.LJ());
                    jSONArray.put(jSONObject);
                }
            }
            builder.history = jSONArray.toString();
            if (z) {
                p.bindCommonParamsToProtobufData(builder, true);
            }
            GetHistoryForumReqIdl.Builder builder2 = new GetHistoryForumReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
