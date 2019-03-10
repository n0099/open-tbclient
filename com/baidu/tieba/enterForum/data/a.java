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
public class a {
    private boolean Jy;
    private List<com.baidu.tieba.enterForum.multiConcern.b> eBH;
    private HotSearchInfoData eBK;
    private int sortType;
    private int time = 0;
    private e eBF = new e();
    private h eBG = new h();
    private ForumCreateInfoData eBI = new ForumCreateInfoData();
    private PrivateForumPopInfoData eBJ = new PrivateForumPopInfoData();

    public a() {
        this.Jy = true;
        this.Jy = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.eBK;
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
                    this.eBF.bu(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.eBG.bv(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.eBI.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.eBJ.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.eBK = new HotSearchInfoData();
                    this.eBK.a(dataRes.hot_search);
                }
                if (!v.T(dataRes.tag_recommend_forum)) {
                    if (this.eBH == null) {
                        this.eBH = new ArrayList();
                    } else {
                        this.eBH.clear();
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
                                this.eBH.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.eBH = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public e aWa() {
        return this.eBF;
    }

    public void a(e eVar) {
        this.eBF = eVar;
    }

    public void a(h hVar) {
        this.eBG = hVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> aWb() {
        return this.eBH;
    }

    public void bt(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.eBH = list;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.eBI = forumCreateInfoData;
    }

    public ForumCreateInfoData aWc() {
        return this.eBI;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.eBJ = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData aWd() {
        return this.eBJ;
    }

    public void dy(boolean z) {
        this.Jy = z;
    }

    public boolean isSuccess() {
        return this.Jy;
    }

    public boolean aWe() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.cgT.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.cgT.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.eBK = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }
}
