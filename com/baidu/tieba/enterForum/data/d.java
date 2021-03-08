package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bo;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes2.dex */
public class d {
    private HotSearchInfoData iJA;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g iJu = new g();
    private bo iJv = new bo();
    private ForumCreateInfoData iJw = new ForumCreateInfoData();
    private PrivateForumPopInfoData iJx = new PrivateForumPopInfoData();
    private j iJy = new j();
    private com.baidu.tieba.enterForum.a.a.a iJz = new com.baidu.tieba.enterForum.a.a.a();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.iJA;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                if (dataRes.forum_popup_info != null) {
                    this.iJz.a(dataRes.forum_popup_info);
                }
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.iJu.bp(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.iJv.bo(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.iJw.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.iJx.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.iJA = new HotSearchInfoData();
                    this.iJA.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.iJy.cO(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g cvj() {
        return this.iJu;
    }

    public void a(g gVar) {
        this.iJu = gVar;
    }

    public void c(bo boVar) {
        this.iJv = boVar;
    }

    public bo cvk() {
        return this.iJv;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.iJw = forumCreateInfoData;
    }

    public ForumCreateInfoData cvl() {
        return this.iJw;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.iJx = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData cvm() {
        return this.iJx;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean cvn() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.e.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.iJA = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(j jVar) {
        this.iJy = jVar;
    }

    public void a(com.baidu.tieba.enterForum.a.a.a aVar) {
        this.iJz = aVar;
    }

    public com.baidu.tieba.enterForum.a.a.a cvo() {
        return this.iJz;
    }
}
