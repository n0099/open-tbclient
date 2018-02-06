package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.DataRes;
import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class b {
    private boolean apP;
    private List<com.baidu.tieba.enterForum.multiConcern.b> dpf;
    private HotSearchInfoData dpg;
    private int time = 0;
    private g dpd = new g();
    private j dpe = new j();

    public b() {
        this.apP = true;
        this.apP = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.dpg;
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
                if (dataRes.like_forum != null) {
                    this.dpd.aM(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.dpe.aN(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.dpg = new HotSearchInfoData();
                    this.dpg.a(dataRes.hot_search);
                }
                if (!v.E(dataRes.tag_recommend_forum)) {
                    if (this.dpf == null) {
                        this.dpf = new ArrayList();
                    } else {
                        this.dpf.clear();
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
                                this.dpf.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.dpf = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g aqk() {
        return this.dpd;
    }

    public void a(g gVar) {
        this.dpd = gVar;
    }

    public void a(j jVar) {
        this.dpe = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> aql() {
        return this.dpf;
    }

    public void aL(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.dpf = list;
    }

    public void bh(boolean z) {
        this.apP = z;
    }

    public boolean isSuccess() {
        return this.apP;
    }

    public boolean aqm() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.bqX.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.bqX.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.dpg = hotSearchInfoData;
    }
}
