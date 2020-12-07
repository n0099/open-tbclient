package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bl;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes22.dex */
public class d {
    private boolean isSucc;
    private HotSearchInfoData iul;
    private int sortType;
    private int time = 0;
    private g iuf = new g();
    private bl iug = new bl();
    private ForumCreateInfoData iuh = new ForumCreateInfoData();
    private PrivateForumPopInfoData iui = new PrivateForumPopInfoData();
    private j iuj = new j();
    private com.baidu.tieba.enterForum.b.a.a iuk = new com.baidu.tieba.enterForum.b.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.iul;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.iuk.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.iuf.bn(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.iug.bm(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.iuh.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.iui.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.iul = new HotSearchInfoData();
                    this.iul.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.iuj.cM(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g cuH() {
        return this.iuf;
    }

    public void a(g gVar) {
        this.iuf = gVar;
    }

    public void c(bl blVar) {
        this.iug = blVar;
    }

    public bl cuI() {
        return this.iug;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.iuh = forumCreateInfoData;
    }

    public ForumCreateInfoData cuJ() {
        return this.iuh;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.iui = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData cuK() {
        return this.iui;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean cuL() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.iul = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.iuj = jVar;
    }

    public void a(com.baidu.tieba.enterForum.b.a.a aVar) {
        this.iuk = aVar;
    }

    public com.baidu.tieba.enterForum.b.a.a cuM() {
        return this.iuk;
    }
}
