package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes9.dex */
public class e {
    private HotSearchInfoData gzN;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private i gzI = new i();
    private l gzJ = new l();
    private ForumCreateInfoData gzK = new ForumCreateInfoData();
    private PrivateForumPopInfoData gzL = new PrivateForumPopInfoData();
    private p gzM = new p();

    public e() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.gzN;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.gzI.bT(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.gzJ.bU(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.gzK.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.gzL.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.gzN = new HotSearchInfoData();
                    this.gzN.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.gzM.bV(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i bHz() {
        return this.gzI;
    }

    public void a(i iVar) {
        this.gzI = iVar;
    }

    public void a(l lVar) {
        this.gzJ = lVar;
    }

    public l bHA() {
        return this.gzJ;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.gzK = forumCreateInfoData;
    }

    public ForumCreateInfoData bHB() {
        return this.gzK;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.gzL = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bHC() {
        return this.gzL;
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
        this.gzN = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(p pVar) {
        this.gzM = pVar;
    }

    public p bHD() {
        return this.gzM;
    }
}
