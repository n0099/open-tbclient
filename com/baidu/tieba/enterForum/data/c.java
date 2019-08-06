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
    private boolean Hs;
    private List<com.baidu.tieba.enterForum.multiConcern.b> eWl;
    private HotSearchInfoData eWo;
    private int sortType;
    private int time = 0;
    private g eWj = new g();
    private j eWk = new j();
    private ForumCreateInfoData eWm = new ForumCreateInfoData();
    private PrivateForumPopInfoData eWn = new PrivateForumPopInfoData();

    public c() {
        this.Hs = true;
        this.Hs = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.eWo;
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
                    this.eWj.bC(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.eWk.bD(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.eWm.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.eWn.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.eWo = new HotSearchInfoData();
                    this.eWo.a(dataRes.hot_search);
                }
                if (!v.aa(dataRes.tag_recommend_forum)) {
                    if (this.eWl == null) {
                        this.eWl = new ArrayList();
                    } else {
                        this.eWl.clear();
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
                                this.eWl.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.eWl = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g bfh() {
        return this.eWj;
    }

    public void a(g gVar) {
        this.eWj = gVar;
    }

    public void a(j jVar) {
        this.eWk = jVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> bfi() {
        return this.eWl;
    }

    public void bB(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.eWl = list;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.eWm = forumCreateInfoData;
    }

    public ForumCreateInfoData bfj() {
        return this.eWm;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.eWn = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bfk() {
        return this.eWn;
    }

    public void dY(boolean z) {
        this.Hs = z;
    }

    public boolean isSuccess() {
        return this.Hs;
    }

    public boolean Zi() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.cqy.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.cqy.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.eWo = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }
}
