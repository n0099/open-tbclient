package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bj;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes16.dex */
public class d {
    private HotSearchInfoData hug;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g hua = new g();
    private bj hub = new bj();
    private ForumCreateInfoData huc = new ForumCreateInfoData();
    private PrivateForumPopInfoData hud = new PrivateForumPopInfoData();
    private j hue = new j();
    private com.baidu.tieba.enterForum.b.a.a huf = new com.baidu.tieba.enterForum.b.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.hug;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.huf.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.hua.aM(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.hub.aL(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.huc.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.hud.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.hug = new HotSearchInfoData();
                    this.hug.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.hue.ci(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g cex() {
        return this.hua;
    }

    public void a(g gVar) {
        this.hua = gVar;
    }

    public void c(bj bjVar) {
        this.hub = bjVar;
    }

    public bj cey() {
        return this.hub;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.huc = forumCreateInfoData;
    }

    public ForumCreateInfoData cez() {
        return this.huc;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.hud = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData ceA() {
        return this.hud;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean ceB() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.hug = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.hue = jVar;
    }

    public void a(com.baidu.tieba.enterForum.b.a.a aVar) {
        this.huf = aVar;
    }

    public com.baidu.tieba.enterForum.b.a.a ceC() {
        return this.huf;
    }
}
