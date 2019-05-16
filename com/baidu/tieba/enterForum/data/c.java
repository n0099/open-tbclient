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
    private boolean Hi;
    private List<com.baidu.tieba.enterForum.multiConcern.b> eRa;
    private HotSearchInfoData eRd;
    private int sortType;
    private int time = 0;
    private g eQY = new g();
    private j eQZ = new j();
    private ForumCreateInfoData eRb = new ForumCreateInfoData();
    private PrivateForumPopInfoData eRc = new PrivateForumPopInfoData();

    public c() {
        this.Hi = true;
        this.Hi = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.eRd;
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
                    this.eQY.bA(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.eQZ.bB(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.eRb.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.eRc.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.eRd = new HotSearchInfoData();
                    this.eRd.a(dataRes.hot_search);
                }
                if (!v.aa(dataRes.tag_recommend_forum)) {
                    if (this.eRa == null) {
                        this.eRa = new ArrayList();
                    } else {
                        this.eRa.clear();
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
                                this.eRa.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.eRa = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g bda() {
        return this.eQY;
    }

    public void a(g gVar) {
        this.eQY = gVar;
    }

    public void a(j jVar) {
        this.eQZ = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> bdb() {
        return this.eRa;
    }

    public void bz(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.eRa = list;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.eRb = forumCreateInfoData;
    }

    public ForumCreateInfoData bdc() {
        return this.eRb;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.eRc = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bdd() {
        return this.eRc;
    }

    public void dU(boolean z) {
        this.Hi = z;
    }

    public boolean isSuccess() {
        return this.Hi;
    }

    public boolean Ym() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.cpd.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.cpd.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.eRd = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }
}
