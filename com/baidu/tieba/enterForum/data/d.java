package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bj;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes16.dex */
public class d {
    private HotSearchInfoData hua;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g htU = new g();
    private bj htV = new bj();
    private ForumCreateInfoData htW = new ForumCreateInfoData();
    private PrivateForumPopInfoData htX = new PrivateForumPopInfoData();
    private j htY = new j();
    private com.baidu.tieba.enterForum.b.a.a htZ = new com.baidu.tieba.enterForum.b.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.hua;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.htZ.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.htU.aM(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.htV.aL(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.htW.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.htX.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.hua = new HotSearchInfoData();
                    this.hua.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.htY.ci(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g cew() {
        return this.htU;
    }

    public void a(g gVar) {
        this.htU = gVar;
    }

    public void c(bj bjVar) {
        this.htV = bjVar;
    }

    public bj cex() {
        return this.htV;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.htW = forumCreateInfoData;
    }

    public ForumCreateInfoData cey() {
        return this.htW;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.htX = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData cez() {
        return this.htX;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean ceA() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.hua = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.htY = jVar;
    }

    public void a(com.baidu.tieba.enterForum.b.a.a aVar) {
        this.htZ = aVar;
    }

    public com.baidu.tieba.enterForum.b.a.a ceB() {
        return this.htZ;
    }
}
