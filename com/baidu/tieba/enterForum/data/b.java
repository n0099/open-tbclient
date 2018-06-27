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
    private boolean Gr;
    private List<com.baidu.tieba.enterForum.multiConcern.b> cPt;
    private HotSearchInfoData cPu;
    private int time = 0;
    private g cPr = new g();
    private j cPs = new j();

    public b() {
        this.Gr = true;
        this.Gr = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.cPu;
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
                    this.cPr.aO(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.cPs.aP(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.cPu = new HotSearchInfoData();
                    this.cPu.a(dataRes.hot_search);
                }
                if (!w.A(dataRes.tag_recommend_forum)) {
                    if (this.cPt == null) {
                        this.cPt = new ArrayList();
                    } else {
                        this.cPt.clear();
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
                                this.cPt.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.cPt = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g anT() {
        return this.cPr;
    }

    public void a(g gVar) {
        this.cPr = gVar;
    }

    public void a(j jVar) {
        this.cPs = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> anU() {
        return this.cPt;
    }

    public void aN(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.cPt = list;
    }

    public void aF(boolean z) {
        this.Gr = z;
    }

    public boolean isSuccess() {
        return this.Gr;
    }

    public boolean anV() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.aKF.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.aKF.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.cPu = hotSearchInfoData;
    }
}
