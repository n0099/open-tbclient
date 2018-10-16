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
    private boolean Jo;
    private List<com.baidu.tieba.enterForum.multiConcern.b> dgh;
    private HotSearchInfoData dgi;
    private int time = 0;
    private g dgf = new g();
    private j dgg = new j();

    public b() {
        this.Jo = true;
        this.Jo = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.dgi;
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
                    this.dgf.be(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.dgg.bf(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.dgi = new HotSearchInfoData();
                    this.dgi.a(dataRes.hot_search);
                }
                if (!v.J(dataRes.tag_recommend_forum)) {
                    if (this.dgh == null) {
                        this.dgh = new ArrayList();
                    } else {
                        this.dgh.clear();
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
                                this.dgh.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.dgh = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g atD() {
        return this.dgf;
    }

    public void a(g gVar) {
        this.dgf = gVar;
    }

    public void a(j jVar) {
        this.dgg = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> atE() {
        return this.dgh;
    }

    public void bd(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.dgh = list;
    }

    public void aX(boolean z) {
        this.Jo = z;
    }

    public boolean isSuccess() {
        return this.Jo;
    }

    public boolean atF() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.aSA.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.aSA.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.dgi = hotSearchInfoData;
    }
}
