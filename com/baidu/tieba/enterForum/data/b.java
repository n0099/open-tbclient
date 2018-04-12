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
    private boolean Aj;
    private List<com.baidu.tieba.enterForum.multiConcern.b> cHl;
    private HotSearchInfoData cHm;
    private int time = 0;
    private g cHj = new g();
    private j cHk = new j();

    public b() {
        this.Aj = true;
        this.Aj = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.cHm;
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
                    this.cHj.aH(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.cHk.aI(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.cHm = new HotSearchInfoData();
                    this.cHm.a(dataRes.hot_search);
                }
                if (!v.w(dataRes.tag_recommend_forum)) {
                    if (this.cHl == null) {
                        this.cHl = new ArrayList();
                    } else {
                        this.cHl.clear();
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
                                this.cHl.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.cHl = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g akt() {
        return this.cHj;
    }

    public void a(g gVar) {
        this.cHj = gVar;
    }

    public void a(j jVar) {
        this.cHk = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> aku() {
        return this.cHl;
    }

    public void aG(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.cHl = list;
    }

    public void az(boolean z) {
        this.Aj = z;
    }

    public boolean isSuccess() {
        return this.Aj;
    }

    public boolean akv() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.aBm.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.aBm.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.cHm = hotSearchInfoData;
    }
}
