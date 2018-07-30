package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.DataRes;
import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class b {
    private boolean Gp;
    private List<com.baidu.tieba.enterForum.multiConcern.b> cSc;
    private HotSearchInfoData cSd;
    private int time = 0;
    private g cSa = new g();
    private j cSb = new j();

    public b() {
        this.Gp = true;
        this.Gp = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.cSd;
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
                    this.cSa.aN(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.cSb.aO(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.cSd = new HotSearchInfoData();
                    this.cSd.a(dataRes.hot_search);
                }
                if (!w.z(dataRes.tag_recommend_forum)) {
                    if (this.cSc == null) {
                        this.cSc = new ArrayList();
                    } else {
                        this.cSc.clear();
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
                                this.cSc.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.cSc = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g aos() {
        return this.cSa;
    }

    public void a(g gVar) {
        this.cSa = gVar;
    }

    public void a(j jVar) {
        this.cSb = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> aot() {
        return this.cSc;
    }

    public void aM(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.cSc = list;
    }

    public void aD(boolean z) {
        this.Gp = z;
    }

    public boolean isSuccess() {
        return this.Gp;
    }

    public boolean aou() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.aKL.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.aKL.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.cSd = hotSearchInfoData;
    }
}
