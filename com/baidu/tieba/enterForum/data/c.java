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
    private List<com.baidu.tieba.enterForum.multiConcern.b> eZM;
    private HotSearchInfoData eZP;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g eZK = new g();
    private j eZL = new j();
    private ForumCreateInfoData eZN = new ForumCreateInfoData();
    private PrivateForumPopInfoData eZO = new PrivateForumPopInfoData();

    public c() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.eZP;
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
                    this.eZK.bP(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.eZL.bQ(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.eZN.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.eZO.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.eZP = new HotSearchInfoData();
                    this.eZP.a(dataRes.hot_search);
                }
                if (!v.isEmpty(dataRes.tag_recommend_forum)) {
                    if (this.eZM == null) {
                        this.eZM = new ArrayList();
                    } else {
                        this.eZM.clear();
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
                                this.eZM.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.eZM = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g bdD() {
        return this.eZK;
    }

    public void a(g gVar) {
        this.eZK = gVar;
    }

    public void a(j jVar) {
        this.eZL = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> bdE() {
        return this.eZM;
    }

    public void bO(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.eZM = list;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.eZN = forumCreateInfoData;
    }

    public ForumCreateInfoData bdF() {
        return this.eZN;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.eZO = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bdG() {
        return this.eZO;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean adZ() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.eZP = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }
}
