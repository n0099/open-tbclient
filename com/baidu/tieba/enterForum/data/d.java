package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bj;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes22.dex */
public class d {
    private HotSearchInfoData icD;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g icx = new g();
    private bj icy = new bj();
    private ForumCreateInfoData icz = new ForumCreateInfoData();
    private PrivateForumPopInfoData icA = new PrivateForumPopInfoData();
    private j icB = new j();
    private com.baidu.tieba.enterForum.b.a.a icC = new com.baidu.tieba.enterForum.b.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.icD;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.icC.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.icx.bd(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.icy.bc(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.icz.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.icA.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.icD = new HotSearchInfoData();
                    this.icD.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.icB.cA(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g cop() {
        return this.icx;
    }

    public void a(g gVar) {
        this.icx = gVar;
    }

    public void c(bj bjVar) {
        this.icy = bjVar;
    }

    public bj coq() {
        return this.icy;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.icz = forumCreateInfoData;
    }

    public ForumCreateInfoData cor() {
        return this.icz;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.icA = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData cos() {
        return this.icA;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean cot() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.icD = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.icB = jVar;
    }

    public void a(com.baidu.tieba.enterForum.b.a.a aVar) {
        this.icC = aVar;
    }

    public com.baidu.tieba.enterForum.b.a.a cou() {
        return this.icC;
    }
}
