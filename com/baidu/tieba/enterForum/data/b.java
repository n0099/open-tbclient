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
    private List<com.baidu.tieba.enterForum.multiConcern.b> csT;
    private HotSearchInfoData csU;
    private int time = 0;
    private g csR = new g();
    private j csS = new j();

    public b() {
        this.BJ = true;
        this.BJ = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.csU;
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
                    this.csR.aB(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.csS.aC(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.csU = new HotSearchInfoData();
                    this.csU.a(dataRes.hot_search);
                }
                if (!v.w(dataRes.tag_recommend_forum)) {
                    if (this.csT == null) {
                        this.csT = new ArrayList();
                    } else {
                        this.csT.clear();
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
                                this.csT.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.csT = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g agM() {
        return this.csR;
    }

    public void a(g gVar) {
        this.csR = gVar;
    }

    public void a(j jVar) {
        this.csS = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> agN() {
        return this.csT;
    }

    public void aA(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.csT = list;
    }

    public void av(boolean z) {
        this.BJ = z;
    }

    public boolean isSuccess() {
        return this.BJ;
    }

    public boolean agO() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.aAg.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.aAg.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.csU = hotSearchInfoData;
    }
}
