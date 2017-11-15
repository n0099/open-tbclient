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
    private List<com.baidu.tieba.enterForum.multiConcern.b> cjZ;
    private HotSearchInfoData cka;
    private int time = 0;
    private g cjX = new g();
    private j cjY = new j();

    public b() {
        this.BJ = true;
        this.BJ = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.cka;
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
                    this.cjX.ap(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.cjY.aq(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.cka = new HotSearchInfoData();
                    this.cka.a(dataRes.hot_search);
                }
                if (!v.v(dataRes.tag_recommend_forum)) {
                    if (this.cjZ == null) {
                        this.cjZ = new ArrayList();
                    } else {
                        this.cjZ.clear();
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
                                this.cjZ.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.cjZ = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g aeT() {
        return this.cjX;
    }

    public void a(g gVar) {
        this.cjX = gVar;
    }

    public void a(j jVar) {
        this.cjY = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> aeU() {
        return this.cjZ;
    }

    public void ao(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.cjZ = list;
    }

    public void av(boolean z) {
        this.BJ = z;
    }

    public boolean isSuccess() {
        return this.BJ;
    }

    public boolean aeV() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.azx.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.azx.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.cka = hotSearchInfoData;
    }
}
