package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.ForumRecommend.DataReq;
import tbclient.ForumRecommend.ForumRecommendReqIdl;
/* loaded from: classes.dex */
public class forumRecommendRequestMessage extends NetMessage {
    private Integer like_forum;
    private Integer recommend;
    private Integer topic;

    public forumRecommendRequestMessage() {
        super(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    }

    public Integer get_like_forum() {
        return this.like_forum;
    }

    public void set_like_forum(Integer num) {
        this.like_forum = num;
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

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.like_forum = get_like_forum();
            builder.topic = get_topic();
            builder.recommend = get_recommend();
            if (z) {
                com.baidu.tbadk.util.n.a(builder, true);
            }
            ForumRecommendReqIdl.Builder builder2 = new ForumRecommendReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
