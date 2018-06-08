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
    private List<com.baidu.tieba.enterForum.multiConcern.b> cRy;
    private HotSearchInfoData cRz;
    private int time = 0;
    private g cRw = new g();
    private j cRx = new j();

    public b() {
        this.Gp = true;
        this.Gp = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.cRz;
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
                    this.cRw.aN(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.cRx.aO(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.cRz = new HotSearchInfoData();
                    this.cRz.a(dataRes.hot_search);
                }
                if (!w.z(dataRes.tag_recommend_forum)) {
                    if (this.cRy == null) {
                        this.cRy = new ArrayList();
                    } else {
                        this.cRy.clear();
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
                                this.cRy.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.cRy = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g aoz() {
        return this.cRw;
    }

    public void a(g gVar) {
        this.cRw = gVar;
    }

    public void a(j jVar) {
        this.cRx = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> aoA() {
        return this.cRy;
    }

    public void aM(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.cRy = list;
    }

    public void aD(boolean z) {
        this.Gp = z;
    }

    public boolean isSuccess() {
        return this.Gp;
    }

    public boolean aoB() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.aJI.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.aJI.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.cRz = hotSearchInfoData;
    }
}
