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
    private List<com.baidu.tieba.enterForum.multiConcern.b> eBo;
    private HotSearchInfoData eBr;
    private int sortType;
    private int time = 0;
    private e eBm = new e();
    private h eBn = new h();
    private ForumCreateInfoData eBp = new ForumCreateInfoData();
    private PrivateForumPopInfoData eBq = new PrivateForumPopInfoData();

    public a() {
        this.Jy = true;
        this.Jy = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.eBr;
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
                    this.eBm.bs(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.eBn.bt(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.eBp.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.eBq.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.eBr = new HotSearchInfoData();
                    this.eBr.a(dataRes.hot_search);
                }
                if (!v.T(dataRes.tag_recommend_forum)) {
                    if (this.eBo == null) {
                        this.eBo = new ArrayList();
                    } else {
                        this.eBo.clear();
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
                                this.eBo.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.eBo = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public e aVX() {
        return this.eBm;
    }

    public void a(e eVar) {
        this.eBm = eVar;
    }

    public void a(h hVar) {
        this.eBn = hVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> aVY() {
        return this.eBo;
    }

    public void br(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.eBo = list;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.eBp = forumCreateInfoData;
    }

    public ForumCreateInfoData aVZ() {
        return this.eBp;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.eBq = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData aWa() {
        return this.eBq;
    }

    public void dy(boolean z) {
        this.Jy = z;
    }

    public boolean isSuccess() {
        return this.Jy;
    }

    public boolean aWb() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.cgV.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.cgV.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.eBr = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }
}
