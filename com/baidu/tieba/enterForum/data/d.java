package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bo;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes2.dex */
public class d {
    private HotSearchInfoData iHD;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g iHx = new g();
    private bo iHy = new bo();
    private ForumCreateInfoData iHz = new ForumCreateInfoData();
    private PrivateForumPopInfoData iHA = new PrivateForumPopInfoData();
    private j iHB = new j();
    private com.baidu.tieba.enterForum.a.a.a iHC = new com.baidu.tieba.enterForum.a.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.iHD;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.iHC.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.iHx.bp(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.iHy.bo(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.iHz.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.iHA.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.iHD = new HotSearchInfoData();
                    this.iHD.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.iHB.cO(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g cuW() {
        return this.iHx;
    }

    public void a(g gVar) {
        this.iHx = gVar;
    }

    public void c(bo boVar) {
        this.iHy = boVar;
    }

    public bo cuX() {
        return this.iHy;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.iHz = forumCreateInfoData;
    }

    public ForumCreateInfoData cuY() {
        return this.iHz;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.iHA = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData cuZ() {
        return this.iHA;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean cva() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.iHD = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.iHB = jVar;
    }

    public void a(com.baidu.tieba.enterForum.a.a.a aVar) {
        this.iHC = aVar;
    }

    public com.baidu.tieba.enterForum.a.a.a cvb() {
        return this.iHC;
    }
}
