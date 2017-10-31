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
    private List<com.baidu.tieba.enterForum.multiConcern.b> cjM;
    private HotSearchInfoData cjN;
    private int time = 0;
    private g cjK = new g();
    private j cjL = new j();

    public b() {
        this.BJ = true;
        this.BJ = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.cjN;
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
                    this.cjK.ap(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.cjL.aq(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.cjN = new HotSearchInfoData();
                    this.cjN.a(dataRes.hot_search);
                }
                if (!v.v(dataRes.tag_recommend_forum)) {
                    if (this.cjM == null) {
                        this.cjM = new ArrayList();
                    } else {
                        this.cjM.clear();
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
                                this.cjM.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.cjM = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g aeH() {
        return this.cjK;
    }

    public void a(g gVar) {
        this.cjK = gVar;
    }

    public void a(j jVar) {
        this.cjL = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> aeI() {
        return this.cjM;
    }

    public void ao(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.cjM = list;
    }

    public void av(boolean z) {
        this.BJ = z;
    }

    public boolean isSuccess() {
        return this.BJ;
    }

    public boolean aeJ() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.azp.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.azp.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.cjN = hotSearchInfoData;
    }
}
