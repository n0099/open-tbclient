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
    private List<com.baidu.tieba.enterForum.multiConcern.b> cRZ;
    private HotSearchInfoData cSa;
    private int time = 0;
    private g cRX = new g();
    private j cRY = new j();

    public b() {
        this.Gp = true;
        this.Gp = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.cSa;
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
                    this.cRX.aN(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.cRY.aO(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.cSa = new HotSearchInfoData();
                    this.cSa.a(dataRes.hot_search);
                }
                if (!w.z(dataRes.tag_recommend_forum)) {
                    if (this.cRZ == null) {
                        this.cRZ = new ArrayList();
                    } else {
                        this.cRZ.clear();
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
                                this.cRZ.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.cRZ = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g aos() {
        return this.cRX;
    }

    public void a(g gVar) {
        this.cRX = gVar;
    }

    public void a(j jVar) {
        this.cRY = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> aot() {
        return this.cRZ;
    }

    public void aM(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.cRZ = list;
    }

    public void aE(boolean z) {
        this.Gp = z;
    }

    public boolean isSuccess() {
        return this.Gp;
    }

    public boolean aou() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.aKI.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.aKI.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.cSa = hotSearchInfoData;
    }
}
