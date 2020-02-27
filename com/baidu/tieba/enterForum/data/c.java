package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes9.dex */
public class c {
    private HotSearchInfoData fTZ;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g fTV = new g();
    private j fTW = new j();
    private ForumCreateInfoData fTX = new ForumCreateInfoData();
    private PrivateForumPopInfoData fTY = new PrivateForumPopInfoData();

    public c() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.fTZ;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                setTime(dataRes.time.intValue());
                this.sortType = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
                if (dataRes.like_forum != null) {
                    this.fTV.bK(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.fTW.bL(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.fTX.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.fTY.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.fTZ = new HotSearchInfoData();
                    this.fTZ.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g bxF() {
        return this.fTV;
    }

    public void a(g gVar) {
        this.fTV = gVar;
    }

    public void a(j jVar) {
        this.fTW = jVar;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.fTX = forumCreateInfoData;
    }

    public ForumCreateInfoData bxG() {
        return this.fTX;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.fTY = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bxH() {
        return this.fTY;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean axz() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.fTZ = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }
}
