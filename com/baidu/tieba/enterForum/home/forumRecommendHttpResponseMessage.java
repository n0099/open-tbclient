package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.ForumRecommend.Banner;
import tbclient.ForumRecommend.ForumRecommendResIdl;
import tbclient.ForumRecommend.LikeForum;
import tbclient.ForumRecommend.NewRecommend;
import tbclient.FrequentlyForumInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class forumRecommendHttpResponseMessage extends TbHttpResponsedMessage {
    private List<Banner> banner;
    private List<FrequentlyForumInfo> frequently_forum_info;
    private com.baidu.tieba.enterForum.b.d hotSearchInfo;
    private Integer is_login;
    private Integer is_mem;
    private List<LikeForum> like_forum;
    private Integer msign_level;
    private String msign_text;
    private Integer msign_valid;
    private List<Banner> new_banner_info;
    private List<NewRecommend> new_recommend;
    private List<RecommendForumInfo> recommend_forum_info;
    private int redirect;
    private Integer time;

    public forumRecommendHttpResponseMessage(int i) {
        super(i);
    }

    public int getRedirect() {
        return this.redirect;
    }

    public List<Banner> getNewBannerInfo() {
        return this.new_banner_info;
    }

    public List<LikeForum> GetLikeForum() {
        return this.like_forum;
    }

    public List<Banner> GetBanner() {
        return this.banner;
    }

    public List<NewRecommend> GetNewRecommend() {
        return this.new_recommend;
    }

    public Integer GetIsLogin() {
        return this.is_login;
    }

    public Integer GetMsignValid() {
        return this.msign_valid;
    }

    public String GetMsignText() {
        return this.msign_text;
    }

    public Integer GetMsignLevel() {
        return this.msign_level;
    }

    public Integer GetTime() {
        return this.time;
    }

    public Integer GetIsMem() {
        return this.is_mem;
    }

    public List<RecommendForumInfo> GetRecommendForumInfoList() {
        return this.recommend_forum_info;
    }

    public com.baidu.tieba.enterForum.b.d getHotSearchInfoData() {
        return this.hotSearchInfo;
    }

    public List<FrequentlyForumInfo> getFrequentlyForumInfo() {
        return this.frequently_forum_info;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
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
                this.banner = forumRecommendResIdl.data.banner;
                this.new_recommend = forumRecommendResIdl.data.new_recommend;
                this.is_login = forumRecommendResIdl.data.is_login;
                this.msign_valid = forumRecommendResIdl.data.msign_valid;
                this.msign_text = forumRecommendResIdl.data.msign_text;
                this.msign_level = forumRecommendResIdl.data.msign_level;
                this.time = forumRecommendResIdl.data.time;
                this.is_mem = forumRecommendResIdl.data.is_mem;
                this.recommend_forum_info = forumRecommendResIdl.data.recommend_forum_info;
                this.redirect = forumRecommendResIdl.data.redirect.intValue();
                this.new_banner_info = forumRecommendResIdl.data.new_banner_info;
                this.frequently_forum_info = forumRecommendResIdl.data.frequently_forum_info;
                if (forumRecommendResIdl.data.hot_search != null) {
                    this.hotSearchInfo = new com.baidu.tieba.enterForum.b.d();
                    this.hotSearchInfo.a(forumRecommendResIdl.data.hot_search);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (bArr != null && bArr.length > 0 && getError() == 0) {
            com.baidu.tbadk.core.b.a.tm().M("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName()).l("forumRecommend_cache_key", bArr);
        }
    }
}
