package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.squareup.wire.Wire;
import d.b.h0.r.r.a;
import java.util.List;
import tbclient.Error;
import tbclient.ForumCreateInfo;
import tbclient.ForumPopupInfo;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
import tbclient.ForumRecommend.LikeForum;
import tbclient.FrsTabInfo;
import tbclient.PrivatePopInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class forumRecommendHttpResponseMessage extends TbHttpResponsedMessage {
    public ForumCreateInfo forum_create_info;
    public ForumPopupInfo forum_popup_info;
    public HotSearchInfoData hotSearchInfo;
    public List<LikeForum> like_forum;
    public PrivatePopInfo private_pop_info;
    public List<RecommendForumInfo> recommend_concern_forums;
    public List<RecommendForumInfo> recommend_forum_info;
    public Integer sortType;
    public List<FrsTabInfo> tabFeedList;
    public Integer time;

    public forumRecommendHttpResponseMessage(int i) {
        super(i);
        this.sortType = 0;
    }

    public List<LikeForum> GetLikeForum() {
        return this.like_forum;
    }

    public List<RecommendForumInfo> GetRecommendForumInfoList() {
        return this.recommend_forum_info;
    }

    public Integer GetTime() {
        return this.time;
    }

    public ForumCreateInfo getForumCreateInfo() {
        return this.forum_create_info;
    }

    public ForumPopupInfo getForumPopUpInfo() {
        return this.forum_popup_info;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.hotSearchInfo;
    }

    public PrivatePopInfo getPrivatePopInfo() {
        return this.private_pop_info;
    }

    public List<RecommendForumInfo> getRecommendConcernForums() {
        return this.recommend_concern_forums;
    }

    public Integer getSortType() {
        return this.sortType;
    }

    public List<FrsTabInfo> getTabFeedList() {
        return this.tabFeedList;
    }

    public void setSortType(Integer num) {
        this.sortType = num;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (bArr == null || bArr.length <= 0 || getError() != 0) {
            return;
        }
        a.f().e("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName()).a(EnterForumModel.FORUMRECOMMEND_CACHE_KEY, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ForumRecommendResIdl forumRecommendResIdl;
        DataRes dataRes;
        String str;
        Integer num;
        if (bArr == null || (forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class)) == null) {
            return;
        }
        Error error = forumRecommendResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = forumRecommendResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(forumRecommendResIdl.error.usermsg);
        }
        if (getError() == 0 && (dataRes = forumRecommendResIdl.data) != null) {
            this.like_forum = dataRes.like_forum;
            this.time = dataRes.time;
            this.recommend_forum_info = dataRes.recommend_forum_info;
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.hotSearchInfo = hotSearchInfoData;
                hotSearchInfoData.t(forumRecommendResIdl.data.hot_search);
            }
            DataRes dataRes2 = forumRecommendResIdl.data;
            this.recommend_concern_forums = dataRes2.tag_recommend_forum;
            this.sortType = Integer.valueOf(dataRes2.sort_type.intValue() == 0 ? 1 : forumRecommendResIdl.data.sort_type.intValue());
            DataRes dataRes3 = forumRecommendResIdl.data;
            this.forum_create_info = dataRes3.forum_create_info;
            this.private_pop_info = dataRes3.private_forum_popinfo;
            this.tabFeedList = dataRes3.nav_tab_info;
            this.forum_popup_info = dataRes3.forum_popup_info;
        }
    }
}
