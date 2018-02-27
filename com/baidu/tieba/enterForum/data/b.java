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
    private boolean apG;
    private List<com.baidu.tieba.enterForum.multiConcern.b> doT;
    private HotSearchInfoData doU;
    private int time = 0;
    private g doR = new g();
    private j doS = new j();

    public b() {
        this.apG = true;
        this.apG = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.doU;
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
                    this.doR.aM(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.doS.aN(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.doU = new HotSearchInfoData();
                    this.doU.a(dataRes.hot_search);
                }
                if (!v.E(dataRes.tag_recommend_forum)) {
                    if (this.doT == null) {
                        this.doT = new ArrayList();
                    } else {
                        this.doT.clear();
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
                                this.doT.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.doT = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g aqj() {
        return this.doR;
    }

    public void a(g gVar) {
        this.doR = gVar;
    }

    public void a(j jVar) {
        this.doS = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> aqk() {
        return this.doT;
    }

    public void aL(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.doT = list;
    }

    public void bh(boolean z) {
        this.apG = z;
    }

    public boolean isSuccess() {
        return this.apG;
    }

    public boolean aql() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.bqK.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.bqK.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.doU = hotSearchInfoData;
    }
}
