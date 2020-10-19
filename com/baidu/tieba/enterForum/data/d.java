package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bj;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes22.dex */
public class d {
    private HotSearchInfoData hQg;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g hQa = new g();
    private bj hQb = new bj();
    private ForumCreateInfoData hQc = new ForumCreateInfoData();
    private PrivateForumPopInfoData hQd = new PrivateForumPopInfoData();
    private j hQe = new j();
    private com.baidu.tieba.enterForum.b.a.a hQf = new com.baidu.tieba.enterForum.b.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.hQg;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.hQf.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.hQa.aT(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.hQb.aS(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.hQc.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.hQd.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.hQg = new HotSearchInfoData();
                    this.hQg.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.hQe.cr(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g cli() {
        return this.hQa;
    }

    public void a(g gVar) {
        this.hQa = gVar;
    }

    public void c(bj bjVar) {
        this.hQb = bjVar;
    }

    public bj clj() {
        return this.hQb;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.hQc = forumCreateInfoData;
    }

    public ForumCreateInfoData clk() {
        return this.hQc;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.hQd = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData cll() {
        return this.hQd;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean clm() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.hQg = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.hQe = jVar;
    }

    public void a(com.baidu.tieba.enterForum.b.a.a aVar) {
        this.hQf = aVar;
    }

    public com.baidu.tieba.enterForum.b.a.a cln() {
        return this.hQf;
    }
}
