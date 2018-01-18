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
    private boolean apN;
    private List<com.baidu.tieba.enterForum.multiConcern.b> dlT;
    private HotSearchInfoData dlU;
    private int time = 0;
    private g dlR = new g();
    private j dlS = new j();

    public b() {
        this.apN = true;
        this.apN = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.dlU;
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
                    this.dlR.aK(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.dlS.aL(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.dlU = new HotSearchInfoData();
                    this.dlU.a(dataRes.hot_search);
                }
                if (!v.E(dataRes.tag_recommend_forum)) {
                    if (this.dlT == null) {
                        this.dlT = new ArrayList();
                    } else {
                        this.dlT.clear();
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
                                this.dlT.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.dlT = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g apq() {
        return this.dlR;
    }

    public void a(g gVar) {
        this.dlR = gVar;
    }

    public void a(j jVar) {
        this.dlS = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> apr() {
        return this.dlT;
    }

    public void aJ(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.dlT = list;
    }

    public void bd(boolean z) {
        this.apN = z;
    }

    public boolean isSuccess() {
        return this.apN;
    }

    public boolean aps() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.boA.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.boA.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.dlU = hotSearchInfoData;
    }
}
