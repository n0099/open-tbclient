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
    private boolean apQ;
    private List<com.baidu.tieba.enterForum.multiConcern.b> dmo;
    private HotSearchInfoData dmp;
    private int time = 0;
    private g dmm = new g();
    private j dmn = new j();

    public b() {
        this.apQ = true;
        this.apQ = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.dmp;
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
                    this.dmm.aK(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.dmn.aL(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.dmp = new HotSearchInfoData();
                    this.dmp.a(dataRes.hot_search);
                }
                if (!v.E(dataRes.tag_recommend_forum)) {
                    if (this.dmo == null) {
                        this.dmo = new ArrayList();
                    } else {
                        this.dmo.clear();
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
                                this.dmo.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.dmo = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g apv() {
        return this.dmm;
    }

    public void a(g gVar) {
        this.dmm = gVar;
    }

    public void a(j jVar) {
        this.dmn = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> apw() {
        return this.dmo;
    }

    public void aJ(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.dmo = list;
    }

    public void be(boolean z) {
        this.apQ = z;
    }

    public boolean isSuccess() {
        return this.apQ;
    }

    public boolean apx() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.boJ.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.boJ.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.dmp = hotSearchInfoData;
    }
}
