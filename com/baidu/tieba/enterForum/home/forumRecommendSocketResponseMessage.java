package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.ForumRecommend.Banner;
import tbclient.ForumRecommend.ForumRecommendResIdl;
import tbclient.ForumRecommend.LikeForum;
import tbclient.ForumRecommend.NewRecommend;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class forumRecommendSocketResponseMessage extends SocketResponsedMessage {
    private List<Banner> banner;
    private Integer is_login;
    private Integer is_mem;
    private List<LikeForum> like_forum;
    private Integer msign_level;
    private String msign_text;
    private Integer msign_valid;
    private List<NewRecommend> new_recommend;
    private List<RecommendForumInfo> recommend_forum_info;
    private Integer time;

    public forumRecommendSocketResponseMessage() {
        super(303011);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
        if (forumRecommendResIdl != null) {
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
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (bArr != null && bArr.length > 0 && getError() == 0) {
            com.baidu.tbadk.core.b.a.sM().U("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName()).g("forumRecommend_cache_key", bArr);
        }
    }
}
