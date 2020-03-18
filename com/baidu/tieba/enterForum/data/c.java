package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes9.dex */
public class c {
    private HotSearchInfoData fUX;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g fUT = new g();
    private j fUU = new j();
    private ForumCreateInfoData fUV = new ForumCreateInfoData();
    private PrivateForumPopInfoData fUW = new PrivateForumPopInfoData();

    public c() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.fUX;
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
                    this.fUT.bK(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.fUU.bL(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.fUV.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.fUW.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.fUX = new HotSearchInfoData();
                    this.fUX.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g bxN() {
        return this.fUT;
    }

    public void a(g gVar) {
        this.fUT = gVar;
    }

    public void a(j jVar) {
        this.fUU = jVar;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.fUV = forumCreateInfoData;
    }

    public ForumCreateInfoData bxO() {
        return this.fUV;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.fUW = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bxP() {
        return this.fUW;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean axE() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.fUX = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }
}
