package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.DataRes;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class b {
    private boolean BJ;
    private List<com.baidu.tieba.enterForum.multiConcern.b> csG;
    private HotSearchInfoData csH;
    private int time = 0;
    private g csE = new g();
    private j csF = new j();

    public b() {
        this.BJ = true;
        this.BJ = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.csH;
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
                    this.csE.aB(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.csF.aC(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.csH = new HotSearchInfoData();
                    this.csH.a(dataRes.hot_search);
                }
                if (!v.w(dataRes.tag_recommend_forum)) {
                    if (this.csG == null) {
                        this.csG = new ArrayList();
                    } else {
                        this.csG.clear();
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
                                this.csG.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.csG = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g agF() {
        return this.csE;
    }

    public void a(g gVar) {
        this.csE = gVar;
    }

    public void a(j jVar) {
        this.csF = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> agG() {
        return this.csG;
    }

    public void aA(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.csG = list;
    }

    public void av(boolean z) {
        this.BJ = z;
    }

    public boolean isSuccess() {
        return this.BJ;
    }

    public boolean agH() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.azY.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.azY.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.csH = hotSearchInfoData;
    }
}
