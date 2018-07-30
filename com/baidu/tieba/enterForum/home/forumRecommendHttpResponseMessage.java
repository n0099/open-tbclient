package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.ForumRecommend.ForumRecommendResIdl;
import tbclient.ForumRecommend.LikeForum;
import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class forumRecommendHttpResponseMessage extends TbHttpResponsedMessage {
    private HotSearchInfoData hotSearchInfo;
    private List<LikeForum> like_forum;
    private List<RecommendForumInfo> recommend_concern_forums;
    private List<RecommendForumInfo> recommend_forum_info;
    private Integer time;

    public forumRecommendHttpResponseMessage(int i) {
        super(i);
    }

    public List<LikeForum> GetLikeForum() {
        return this.like_forum;
    }

    public Integer GetTime() {
        return this.time;
    }

    public List<RecommendForumInfo> GetRecommendForumInfoList() {
        return this.recommend_forum_info;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.hotSearchInfo;
    }

    public List<RecommendForumInfo> getRecommendConcernForums() {
        return this.recommend_concern_forums;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ForumRecommendResIdl forumRecommendResIdl;
        if (bArr != null && (forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class)) != null) {
            if (forumRecommendResIdl.error != null && forumRecommendResIdl.error.errorno != null) {
                setError(forumRecommendResIdl.error.errorno.intValue());
            }
            if (forumRecommendResIdl.error != null && forumRecommendResIdl.error.usermsg != null && forumRecommendResIdl.error.usermsg.length() > 0) {
                setErrorString(forumRecommendResIdl.error.usermsg);
            }
            if (getError() == 0 && forumRecommendResIdl.data != null) {
                this.like_forum = forumRecommendResIdl.data.like_forum;
                this.time = forumRecommendResIdl.data.time;
                this.recommend_forum_info = forumRecommendResIdl.data.recommend_forum_info;
                if (forumRecommendResIdl.data.hot_search != null) {
                    this.hotSearchInfo = new HotSearchInfoData();
                    this.hotSearchInfo.a(forumRecommendResIdl.data.hot_search);
                }
                this.recommend_concern_forums = forumRecommendResIdl.data.tag_recommend_forum;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (bArr != null && bArr.length > 0 && getError() == 0) {
            com.baidu.tbadk.core.c.a.xb().P("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName()).f(EnterForumModel.FORUMRECOMMEND_CACHE_KEY, bArr);
        }
    }
}
