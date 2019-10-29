package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.DataRes;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class c {
    private List<com.baidu.tieba.enterForum.multiConcern.b> faD;
    private HotSearchInfoData faG;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g faB = new g();
    private j faC = new j();
    private ForumCreateInfoData faE = new ForumCreateInfoData();
    private PrivateForumPopInfoData faF = new PrivateForumPopInfoData();

    public c() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.faG;
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
                this.sortType = dataRes.sort_type.intValue() != 0 ? dataRes.sort_type.intValue() : 1;
                if (dataRes.like_forum != null) {
                    this.faB.bP(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.faC.bQ(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.faE.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.faF.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.faG = new HotSearchInfoData();
                    this.faG.a(dataRes.hot_search);
                }
                if (!v.isEmpty(dataRes.tag_recommend_forum)) {
                    if (this.faD == null) {
                        this.faD = new ArrayList();
                    } else {
                        this.faD.clear();
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
                                this.faD.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.faD = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g bdF() {
        return this.faB;
    }

    public void a(g gVar) {
        this.faB = gVar;
    }

    public void a(j jVar) {
        this.faC = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> bdG() {
        return this.faD;
    }

    public void bO(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.faD = list;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.faE = forumCreateInfoData;
    }

    public ForumCreateInfoData bdH() {
        return this.faE;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.faF = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bdI() {
        return this.faF;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean aeb() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.faG = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }
}
