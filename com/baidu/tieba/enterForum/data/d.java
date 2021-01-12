package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bm;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes2.dex */
public class d {
    private HotSearchInfoData iBT;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g iBN = new g();
    private bm iBO = new bm();
    private ForumCreateInfoData iBP = new ForumCreateInfoData();
    private PrivateForumPopInfoData iBQ = new PrivateForumPopInfoData();
    private j iBR = new j();
    private com.baidu.tieba.enterForum.a.a.a iBS = new com.baidu.tieba.enterForum.a.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.iBT;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.iBS.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.iBN.bu(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.iBO.bt(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.iBP.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.iBQ.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.iBT = new HotSearchInfoData();
                    this.iBT.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.iBR.cT(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g ctK() {
        return this.iBN;
    }

    public void a(g gVar) {
        this.iBN = gVar;
    }

    public void c(bm bmVar) {
        this.iBO = bmVar;
    }

    public bm ctL() {
        return this.iBO;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.iBP = forumCreateInfoData;
    }

    public ForumCreateInfoData ctM() {
        return this.iBP;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.iBQ = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData ctN() {
        return this.iBQ;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean ctO() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.iBT = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.iBR = jVar;
    }

    public void a(com.baidu.tieba.enterForum.a.a.a aVar) {
        this.iBS = aVar;
    }

    public com.baidu.tieba.enterForum.a.a.a ctP() {
        return this.iBS;
    }
}
