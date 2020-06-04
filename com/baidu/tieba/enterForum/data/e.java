package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes9.dex */
public class e {
    private HotSearchInfoData gOO;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private i gOJ = new i();
    private l gOK = new l();
    private ForumCreateInfoData gOL = new ForumCreateInfoData();
    private PrivateForumPopInfoData gOM = new PrivateForumPopInfoData();
    private p gON = new p();

    public e() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.gOO;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.gOJ.bQ(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.gOK.bR(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.gOL.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.gOM.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.gOO = new HotSearchInfoData();
                    this.gOO.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.gON.bS(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i bNT() {
        return this.gOJ;
    }

    public void a(i iVar) {
        this.gOJ = iVar;
    }

    public void a(l lVar) {
        this.gOK = lVar;
    }

    public l bNU() {
        return this.gOK;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.gOL = forumCreateInfoData;
    }

    public ForumCreateInfoData bNV() {
        return this.gOL;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.gOM = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bNW() {
        return this.gOM;
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
        this.gOO = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(p pVar) {
        this.gON = pVar;
    }

    public p bNX() {
        return this.gON;
    }
}
