package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.DataRes;
import tbclient.RecommendForumInfo;
/* loaded from: classes7.dex */
public class c {
    private List<com.baidu.tieba.enterForum.multiConcern.b> fRC;
    private HotSearchInfoData fRF;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g fRA = new g();
    private j fRB = new j();
    private ForumCreateInfoData fRD = new ForumCreateInfoData();
    private PrivateForumPopInfoData fRE = new PrivateForumPopInfoData();

    public c() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.fRF;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        int i;
        if (dataRes != null) {
            try {
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() != 0 ? dataRes.sort_type.intValue() : 1;
                if (dataRes.like_forum != null) {
                    this.fRA.bL(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.fRB.bM(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.fRD.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.fRE.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.fRF = new HotSearchInfoData();
                    this.fRF.a(dataRes.hot_search);
                }
                if (!v.isEmpty(dataRes.tag_recommend_forum)) {
                    if (this.fRC == null) {
                        this.fRC = new ArrayList();
                    } else {
                        this.fRC.clear();
                    }
                    int i2 = 0;
                    for (RecommendForumInfo recommendForumInfo : dataRes.tag_recommend_forum) {
                        if (i2 < 4) {
                            if (recommendForumInfo == null || recommendForumInfo.forum_id.longValue() <= 0 || StringUtils.isNull(recommendForumInfo.forum_name)) {
                                i = i2;
                            } else {
                                com.baidu.tieba.enterForum.multiConcern.b bVar = new com.baidu.tieba.enterForum.multiConcern.b();
                                bVar.avatar = recommendForumInfo.avatar;
                                bVar.forumId = recommendForumInfo.forum_id.longValue();
                                bVar.forumName = recommendForumInfo.forum_name;
                                bVar.followNum = recommendForumInfo.member_count.intValue();
                                bVar.threadNum = recommendForumInfo.thread_count.intValue();
                                bVar.isSelected = true;
                                this.fRC.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.fRC = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g bwb() {
        return this.fRA;
    }

    public void a(g gVar) {
        this.fRA = gVar;
    }

    public void a(j jVar) {
        this.fRB = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> bwc() {
        return this.fRC;
    }

    public void bK(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.fRC = list;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.fRD = forumCreateInfoData;
    }

    public ForumCreateInfoData bwd() {
        return this.fRD;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.fRE = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bwe() {
        return this.fRE;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean avl() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.fRF = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }
}
