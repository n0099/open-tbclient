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
    private List<com.baidu.tieba.enterForum.multiConcern.b> dqL;
    private HotSearchInfoData dqM;
    private int time = 0;
    private g dqJ = new g();
    private j dqK = new j();

    public b() {
        this.Jr = true;
        this.Jr = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.dqM;
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
                    this.dqJ.bf(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.dqK.bg(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.dqM = new HotSearchInfoData();
                    this.dqM.a(dataRes.hot_search);
                }
                if (!v.I(dataRes.tag_recommend_forum)) {
                    if (this.dqL == null) {
                        this.dqL = new ArrayList();
                    } else {
                        this.dqL.clear();
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
                                this.dqL.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.dqL = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g avE() {
        return this.dqJ;
    }

    public void a(g gVar) {
        this.dqJ = gVar;
    }

    public void a(j jVar) {
        this.dqK = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> avF() {
        return this.dqL;
    }

    public void be(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.dqL = list;
    }

    public void bo(boolean z) {
        this.Jr = z;
    }

    public boolean isSuccess() {
        return this.Jr;
    }

    public boolean avG() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.aWQ.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.aWQ.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.dqM = hotSearchInfoData;
    }
}
