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
    private boolean apH;
    private List<com.baidu.tieba.enterForum.multiConcern.b> doW;
    private HotSearchInfoData doX;
    private int time = 0;
    private g doU = new g();
    private j doV = new j();

    public b() {
        this.apH = true;
        this.apH = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.doX;
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
                    this.doU.aM(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.doV.aN(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.doX = new HotSearchInfoData();
                    this.doX.a(dataRes.hot_search);
                }
                if (!v.E(dataRes.tag_recommend_forum)) {
                    if (this.doW == null) {
                        this.doW = new ArrayList();
                    } else {
                        this.doW.clear();
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
                                this.doW.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.doW = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g aqk() {
        return this.doU;
    }

    public void a(g gVar) {
        this.doU = gVar;
    }

    public void a(j jVar) {
        this.doV = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> aql() {
        return this.doW;
    }

    public void aL(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.doW = list;
    }

    public void bh(boolean z) {
        this.apH = z;
    }

    public boolean isSuccess() {
        return this.apH;
    }

    public boolean aqm() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.bqN.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.bqN.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.doX = hotSearchInfoData;
    }
}
