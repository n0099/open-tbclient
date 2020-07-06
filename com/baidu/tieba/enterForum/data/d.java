package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bh;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes9.dex */
public class d {
    private HotSearchInfoData hbB;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g hbw = new g();
    private bh hbx = new bh();
    private ForumCreateInfoData hby = new ForumCreateInfoData();
    private PrivateForumPopInfoData hbz = new PrivateForumPopInfoData();
    private k hbA = new k();

    public d() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.hbB;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.hbw.aF(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.hbx.aE(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.hby.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.hbz.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.hbB = new HotSearchInfoData();
                    this.hbB.a(dataRes.hot_search);
                }
                if (dataRes.nav_tab_info != null) {
                    this.hbA.cb(dataRes.nav_tab_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g bQZ() {
        return this.hbw;
    }

    public void a(g gVar) {
        this.hbw = gVar;
    }

    public void c(bh bhVar) {
        this.hbx = bhVar;
    }

    public bh bRa() {
        return this.hbx;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.hby = forumCreateInfoData;
    }

    public ForumCreateInfoData bRb() {
        return this.hby;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.hbz = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bRc() {
        return this.hbz;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean bRd() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.hbB = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void a(k kVar) {
        this.hbA = kVar;
    }

    public k bRe() {
        return this.hbA;
    }
}
