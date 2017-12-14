package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.DataRes;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class b {
    private boolean BI;
    private List<com.baidu.tieba.enterForum.multiConcern.b> csP;
    private HotSearchInfoData csQ;
    private int time = 0;
    private g csN = new g();
    private j csO = new j();

    public b() {
        this.BI = true;
        this.BI = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.csQ;
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
                    this.csN.aB(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.csO.aC(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.csQ = new HotSearchInfoData();
                    this.csQ.a(dataRes.hot_search);
                }
                if (!v.w(dataRes.tag_recommend_forum)) {
                    if (this.csP == null) {
                        this.csP = new ArrayList();
                    } else {
                        this.csP.clear();
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
                                this.csP.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.csP = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g agN() {
        return this.csN;
    }

    public void a(g gVar) {
        this.csN = gVar;
    }

    public void a(j jVar) {
        this.csO = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> agO() {
        return this.csP;
    }

    public void aA(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.csP = list;
    }

    public void av(boolean z) {
        this.BI = z;
    }

    public boolean isSuccess() {
        return this.BI;
    }

    public boolean agP() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.aAd.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.aAd.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.csQ = hotSearchInfoData;
    }
}
