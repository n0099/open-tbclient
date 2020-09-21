package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bj;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes21.dex */
public class d {
    private HotSearchInfoData hBl;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g hBf = new g();
    private bj hBg = new bj();
    private ForumCreateInfoData hBh = new ForumCreateInfoData();
    private PrivateForumPopInfoData hBi = new PrivateForumPopInfoData();
    private j hBj = new j();
    private com.baidu.tieba.enterForum.b.a.a hBk = new com.baidu.tieba.enterForum.b.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.hBl;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.hBk.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.hBf.aQ(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.hBg.aP(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.hBh.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.hBi.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.hBl = new HotSearchInfoData();
                    this.hBl.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.hBj.co(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g chM() {
        return this.hBf;
    }

    public void a(g gVar) {
        this.hBf = gVar;
    }

    public void c(bj bjVar) {
        this.hBg = bjVar;
    }

    public bj chN() {
        return this.hBg;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.hBh = forumCreateInfoData;
    }

    public ForumCreateInfoData chO() {
        return this.hBh;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.hBi = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData chP() {
        return this.hBi;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean chQ() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.hBl = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.hBj = jVar;
    }

    public void a(com.baidu.tieba.enterForum.b.a.a aVar) {
        this.hBk = aVar;
    }

    public com.baidu.tieba.enterForum.b.a.a chR() {
        return this.hBk;
    }
}
