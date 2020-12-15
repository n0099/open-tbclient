package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bl;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes22.dex */
public class d {
    private boolean isSucc;
    private HotSearchInfoData iun;
    private int sortType;
    private int time = 0;
    private g iuh = new g();
    private bl iui = new bl();
    private ForumCreateInfoData iuj = new ForumCreateInfoData();
    private PrivateForumPopInfoData iuk = new PrivateForumPopInfoData();
    private j iul = new j();
    private com.baidu.tieba.enterForum.b.a.a ium = new com.baidu.tieba.enterForum.b.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.iun;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.ium.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.iuh.bn(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.iui.bm(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.iuj.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.iuk.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.iun = new HotSearchInfoData();
                    this.iun.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.iul.cM(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g cuI() {
        return this.iuh;
    }

    public void a(g gVar) {
        this.iuh = gVar;
    }

    public void c(bl blVar) {
        this.iui = blVar;
    }

    public bl cuJ() {
        return this.iui;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.iuj = forumCreateInfoData;
    }

    public ForumCreateInfoData cuK() {
        return this.iuj;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.iuk = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData cuL() {
        return this.iuk;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean cuM() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.iun = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.iul = jVar;
    }

    public void a(com.baidu.tieba.enterForum.b.a.a aVar) {
        this.ium = aVar;
    }

    public com.baidu.tieba.enterForum.b.a.a cuN() {
        return this.ium;
    }
}
