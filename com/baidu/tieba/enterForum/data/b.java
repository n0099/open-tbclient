package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.DataRes;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    private boolean Jr;
    private List<com.baidu.tieba.enterForum.multiConcern.b> dhm;
    private HotSearchInfoData dhn;
    private int time = 0;
    private g dhk = new g();
    private j dhl = new j();

    public b() {
        this.Jr = true;
        this.Jr = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.dhn;
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
                    this.dhk.bc(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.dhl.bd(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.dhn = new HotSearchInfoData();
                    this.dhn.a(dataRes.hot_search);
                }
                if (!v.I(dataRes.tag_recommend_forum)) {
                    if (this.dhm == null) {
                        this.dhm = new ArrayList();
                    } else {
                        this.dhm.clear();
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
                                this.dhm.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.dhm = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g atd() {
        return this.dhk;
    }

    public void a(g gVar) {
        this.dhk = gVar;
    }

    public void a(j jVar) {
        this.dhl = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> ate() {
        return this.dhm;
    }

    public void bb(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.dhm = list;
    }

    public void bn(boolean z) {
        this.Jr = z;
    }

    public boolean isSuccess() {
        return this.Jr;
    }

    public boolean atf() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.aTq.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.aTq.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.dhn = hotSearchInfoData;
    }
}
