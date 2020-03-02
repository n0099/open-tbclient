package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.t;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ForumRecommend.DataReq;
import tbclient.ForumRecommend.ForumRecommendReqIdl;
/* loaded from: classes9.dex */
public class forumRecommendRequestMessage extends NetMessage {
    private Integer like_forum;
    private LinkedList<VisitedForumData> mForumData;
    private Integer recommend;
    private Integer sortType;
    private Integer topic;
    private String visit_history;

    public forumRecommendRequestMessage() {
        super(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND);
    }

    public Integer get_like_forum() {
        return this.like_forum;
    }

    public String get_visit_history() {
        return this.visit_history;
    }

    public void set_like_forum(Integer num) {
        this.like_forum = num;
    }

    public Integer get_sortType() {
        return this.sortType;
    }

    public void set_sortType(Integer num) {
        this.sortType = num;
    }

    public void set_visit_history(String str) {
        this.visit_history = str;
    }

    public Integer get_topic() {
        return this.topic;
    }

    public void set_topic(Integer num) {
        this.topic = num;
    }

    public Integer get_recommend() {
        return this.recommend;
    }

    public void set_recommend(Integer num) {
        this.recommend = num;
    }

    public void setForumData(LinkedList<VisitedForumData> linkedList) {
        this.mForumData = linkedList;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.like_forum = get_like_forum();
            builder.topic = get_topic();
            builder.recommend = get_recommend();
            builder.sort_type = get_sortType();
            JSONArray jSONArray = new JSONArray();
            if (this.mForumData != null) {
                Iterator<VisitedForumData> it = this.mForumData.iterator();
                while (it.hasNext()) {
                    VisitedForumData next = it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("forum_id", com.baidu.adp.lib.f.b.toLong(next.getForumId(), 0L));
                    jSONObject.put("visit_time", next.aOe());
                    jSONArray.put(jSONObject);
                }
            }
            builder.visit_history = jSONArray.toString();
            if (z) {
                t.a(builder, true);
            }
            ForumRecommendReqIdl.Builder builder2 = new ForumRecommendReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
