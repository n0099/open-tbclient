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
    private boolean apO;
    private List<com.baidu.tieba.enterForum.multiConcern.b> dhr;
    private HotSearchInfoData dhs;
    private int time = 0;
    private g dhp = new g();
    private j dhq = new j();

    public b() {
        this.apO = true;
        this.apO = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.dhs;
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
                    this.dhp.aM(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.dhq.aN(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.dhs = new HotSearchInfoData();
                    this.dhs.a(dataRes.hot_search);
                }
                if (!v.G(dataRes.tag_recommend_forum)) {
                    if (this.dhr == null) {
                        this.dhr = new ArrayList();
                    } else {
                        this.dhr.clear();
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
                                this.dhr.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.dhr = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g aon() {
        return this.dhp;
    }

    public void a(g gVar) {
        this.dhp = gVar;
    }

    public void a(j jVar) {
        this.dhq = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> aoo() {
        return this.dhr;
    }

    public void aL(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.dhr = list;
    }

    public void bd(boolean z) {
        this.apO = z;
    }

    public boolean isSuccess() {
        return this.apO;
    }

    public boolean aop() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.bor.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.bor.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.dhs = hotSearchInfoData;
    }
}
