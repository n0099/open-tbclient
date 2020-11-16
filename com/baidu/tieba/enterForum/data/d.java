package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bk;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes21.dex */
public class d {
    private HotSearchInfoData ijs;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g ijm = new g();
    private bk ijn = new bk();
    private ForumCreateInfoData ijo = new ForumCreateInfoData();
    private PrivateForumPopInfoData ijp = new PrivateForumPopInfoData();
    private j ijq = new j();
    private com.baidu.tieba.enterForum.b.a.a ijr = new com.baidu.tieba.enterForum.b.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.ijs;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.ijr.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.ijm.bk(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.ijn.bj(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.ijo.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.ijp.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.ijs = new HotSearchInfoData();
                    this.ijs.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.ijq.cI(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g cqt() {
        return this.ijm;
    }

    public void a(g gVar) {
        this.ijm = gVar;
    }

    public void c(bk bkVar) {
        this.ijn = bkVar;
    }

    public bk cqu() {
        return this.ijn;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.ijo = forumCreateInfoData;
    }

    public ForumCreateInfoData cqv() {
        return this.ijo;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.ijp = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData cqw() {
        return this.ijp;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean cqx() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.ijs = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.ijq = jVar;
    }

    public void a(com.baidu.tieba.enterForum.b.a.a aVar) {
        this.ijr = aVar;
    }

    public com.baidu.tieba.enterForum.b.a.a cqy() {
        return this.ijr;
    }
}
