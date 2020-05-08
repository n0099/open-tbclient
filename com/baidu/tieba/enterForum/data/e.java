package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes9.dex */
public class e {
    private HotSearchInfoData gzT;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private i gzO = new i();
    private l gzP = new l();
    private ForumCreateInfoData gzQ = new ForumCreateInfoData();
    private PrivateForumPopInfoData gzR = new PrivateForumPopInfoData();
    private p gzS = new p();

    public e() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.gzT;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.gzO.bT(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.gzP.bU(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.gzQ.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.gzR.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.gzT = new HotSearchInfoData();
                    this.gzT.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.gzS.bV(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i bHx() {
        return this.gzO;
    }

    public void a(i iVar) {
        this.gzO = iVar;
    }

    public void a(l lVar) {
        this.gzP = lVar;
    }

    public l bHy() {
        return this.gzP;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.gzQ = forumCreateInfoData;
    }

    public ForumCreateInfoData bHz() {
        return this.gzQ;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.gzR = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bHA() {
        return this.gzR;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean aFP() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.gzT = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(p pVar) {
        this.gzS = pVar;
    }

    public p bHB() {
        return this.gzS;
    }
}
