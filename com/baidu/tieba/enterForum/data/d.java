package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bm;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes2.dex */
public class d {
    private HotSearchInfoData iGA;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g iGu = new g();
    private bm iGv = new bm();
    private ForumCreateInfoData iGw = new ForumCreateInfoData();
    private PrivateForumPopInfoData iGx = new PrivateForumPopInfoData();
    private j iGy = new j();
    private com.baidu.tieba.enterForum.a.a.a iGz = new com.baidu.tieba.enterForum.a.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.iGA;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.iGz.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.iGu.bu(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.iGv.bt(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.iGw.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.iGx.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.iGA = new HotSearchInfoData();
                    this.iGA.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.iGy.cT(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g cxC() {
        return this.iGu;
    }

    public void a(g gVar) {
        this.iGu = gVar;
    }

    public void c(bm bmVar) {
        this.iGv = bmVar;
    }

    public bm cxD() {
        return this.iGv;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.iGw = forumCreateInfoData;
    }

    public ForumCreateInfoData cxE() {
        return this.iGw;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.iGx = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData cxF() {
        return this.iGx;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean cxG() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.iGA = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.iGy = jVar;
    }

    public void a(com.baidu.tieba.enterForum.a.a.a aVar) {
        this.iGz = aVar;
    }

    public com.baidu.tieba.enterForum.a.a.a cxH() {
        return this.iGz;
    }
}
