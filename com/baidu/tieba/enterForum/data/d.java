package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bj;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes22.dex */
public class d {
    private HotSearchInfoData iiE;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g iiy = new g();
    private bj iiz = new bj();
    private ForumCreateInfoData iiA = new ForumCreateInfoData();
    private PrivateForumPopInfoData iiB = new PrivateForumPopInfoData();
    private j iiC = new j();
    private com.baidu.tieba.enterForum.b.a.a iiD = new com.baidu.tieba.enterForum.b.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.iiE;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.iiD.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.iiy.bk(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.iiz.bj(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.iiA.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.iiB.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.iiE = new HotSearchInfoData();
                    this.iiE.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.iiC.cI(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g cqQ() {
        return this.iiy;
    }

    public void a(g gVar) {
        this.iiy = gVar;
    }

    public void c(bj bjVar) {
        this.iiz = bjVar;
    }

    public bj cqR() {
        return this.iiz;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.iiA = forumCreateInfoData;
    }

    public ForumCreateInfoData cqS() {
        return this.iiA;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.iiB = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData cqT() {
        return this.iiB;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean cqU() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.iiE = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.iiC = jVar;
    }

    public void a(com.baidu.tieba.enterForum.b.a.a aVar) {
        this.iiD = aVar;
    }

    public com.baidu.tieba.enterForum.b.a.a cqV() {
        return this.iiD;
    }
}
