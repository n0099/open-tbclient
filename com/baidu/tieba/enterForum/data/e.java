package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes9.dex */
public class e {
    private HotSearchInfoData gOD;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private i gOy = new i();
    private l gOz = new l();
    private ForumCreateInfoData gOA = new ForumCreateInfoData();
    private PrivateForumPopInfoData gOB = new PrivateForumPopInfoData();
    private p gOC = new p();

    public e() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.gOD;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.gOy.bQ(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.gOz.bR(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.gOA.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.gOB.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.gOD = new HotSearchInfoData();
                    this.gOD.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.gOC.bS(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i bNR() {
        return this.gOy;
    }

    public void a(i iVar) {
        this.gOy = iVar;
    }

    public void a(l lVar) {
        this.gOz = lVar;
    }

    public l bNS() {
        return this.gOz;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.gOA = forumCreateInfoData;
    }

    public ForumCreateInfoData bNT() {
        return this.gOA;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.gOB = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bNU() {
        return this.gOB;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean aLk() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.gOD = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(p pVar) {
        this.gOC = pVar;
    }

    public p bNV() {
        return this.gOC;
    }
}
