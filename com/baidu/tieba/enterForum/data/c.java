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
/* loaded from: classes4.dex */
public class c {
    private boolean Hs;
    private List<com.baidu.tieba.enterForum.multiConcern.b> eWb;
    private HotSearchInfoData eWe;
    private int sortType;
    private int time = 0;
    private g eVZ = new g();
    private j eWa = new j();
    private ForumCreateInfoData eWc = new ForumCreateInfoData();
    private PrivateForumPopInfoData eWd = new PrivateForumPopInfoData();

    public c() {
        this.Hs = true;
        this.Hs = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.eWe;
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
                    this.eVZ.bC(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.eWa.bD(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.eWc.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.eWd.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.eWe = new HotSearchInfoData();
                    this.eWe.a(dataRes.hot_search);
                }
                if (!v.aa(dataRes.tag_recommend_forum)) {
                    if (this.eWb == null) {
                        this.eWb = new ArrayList();
                    } else {
                        this.eWb.clear();
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
                                this.eWb.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.eWb = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g bff() {
        return this.eVZ;
    }

    public void a(g gVar) {
        this.eVZ = gVar;
    }

    public void a(j jVar) {
        this.eWa = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> bfg() {
        return this.eWb;
    }

    public void bB(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.eWb = list;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.eWc = forumCreateInfoData;
    }

    public ForumCreateInfoData bfh() {
        return this.eWc;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.eWd = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bfi() {
        return this.eWd;
    }

    public void dY(boolean z) {
        this.Hs = z;
    }

    public boolean isSuccess() {
        return this.Hs;
    }

    public boolean Zi() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.cqr.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.cqr.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.eWe = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }
}
