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
    private boolean Hh;
    private List<com.baidu.tieba.enterForum.multiConcern.b> eRb;
    private HotSearchInfoData eRe;
    private int sortType;
    private int time = 0;
    private g eQZ = new g();
    private j eRa = new j();
    private ForumCreateInfoData eRc = new ForumCreateInfoData();
    private PrivateForumPopInfoData eRd = new PrivateForumPopInfoData();

    public c() {
        this.Hh = true;
        this.Hh = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.eRe;
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
                    this.eQZ.bA(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.eRa.bB(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.eRc.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.eRd.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.eRe = new HotSearchInfoData();
                    this.eRe.a(dataRes.hot_search);
                }
                if (!v.aa(dataRes.tag_recommend_forum)) {
                    if (this.eRb == null) {
                        this.eRb = new ArrayList();
                    } else {
                        this.eRb.clear();
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
                                this.eRb.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.eRb = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g bdd() {
        return this.eQZ;
    }

    public void a(g gVar) {
        this.eQZ = gVar;
    }

    public void a(j jVar) {
        this.eRa = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> bde() {
        return this.eRb;
    }

    public void bz(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.eRb = list;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.eRc = forumCreateInfoData;
    }

    public ForumCreateInfoData bdf() {
        return this.eRc;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.eRd = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bdg() {
        return this.eRd;
    }

    public void dU(boolean z) {
        this.Hh = z;
    }

    public boolean isSuccess() {
        return this.Hh;
    }

    public boolean Ym() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.cpe.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.cpe.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.eRe = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }
}
