package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bo;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes2.dex */
public class d {
    private HotSearchInfoData iHR;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g iHL = new g();
    private bo iHM = new bo();
    private ForumCreateInfoData iHN = new ForumCreateInfoData();
    private PrivateForumPopInfoData iHO = new PrivateForumPopInfoData();
    private j iHP = new j();
    private com.baidu.tieba.enterForum.a.a.a iHQ = new com.baidu.tieba.enterForum.a.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.iHR;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.iHQ.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.iHL.bp(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.iHM.bo(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.iHN.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.iHO.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.iHR = new HotSearchInfoData();
                    this.iHR.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.iHP.cO(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g cvd() {
        return this.iHL;
    }

    public void a(g gVar) {
        this.iHL = gVar;
    }

    public void c(bo boVar) {
        this.iHM = boVar;
    }

    public bo cve() {
        return this.iHM;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.iHN = forumCreateInfoData;
    }

    public ForumCreateInfoData cvf() {
        return this.iHN;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.iHO = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData cvg() {
        return this.iHO;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean cvh() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.iHR = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.iHP = jVar;
    }

    public void a(com.baidu.tieba.enterForum.a.a.a aVar) {
        this.iHQ = aVar;
    }

    public com.baidu.tieba.enterForum.a.a.a cvi() {
        return this.iHQ;
    }
}
