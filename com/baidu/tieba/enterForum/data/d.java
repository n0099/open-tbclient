package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bi;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes16.dex */
public class d {
    private HotSearchInfoData hhh;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g hhb = new g();
    private bi hhc = new bi();
    private ForumCreateInfoData hhd = new ForumCreateInfoData();
    private PrivateForumPopInfoData hhe = new PrivateForumPopInfoData();
    private j hhf = new j();
    private com.baidu.tieba.enterForum.b.a.a hhg = new com.baidu.tieba.enterForum.b.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.hhh;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.hhg.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.hhb.aM(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.hhc.aL(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.hhd.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.hhe.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.hhh = new HotSearchInfoData();
                    this.hhh.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.hhf.cg(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g bUk() {
        return this.hhb;
    }

    public void a(g gVar) {
        this.hhb = gVar;
    }

    public void c(bi biVar) {
        this.hhc = biVar;
    }

    public bi bUl() {
        return this.hhc;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.hhd = forumCreateInfoData;
    }

    public ForumCreateInfoData bUm() {
        return this.hhd;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.hhe = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bUn() {
        return this.hhe;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean bUo() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.hhh = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.hhf = jVar;
    }

    public j bUp() {
        return this.hhf;
    }

    public void a(com.baidu.tieba.enterForum.b.a.a aVar) {
        this.hhg = aVar;
    }

    public com.baidu.tieba.enterForum.b.a.a bUq() {
        return this.hhg;
    }
}
