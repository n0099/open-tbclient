package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes9.dex */
public class c {
    private HotSearchInfoData fUo;
    private boolean isSucc;
    private int sortType;
    private int time = 0;
    private g fUk = new g();
    private j fUl = new j();
    private ForumCreateInfoData fUm = new ForumCreateInfoData();
    private PrivateForumPopInfoData fUn = new PrivateForumPopInfoData();

    public c() {
        this.isSucc = true;
        this.isSucc = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        return this.fUo;
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
                    this.fUk.bK(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.fUl.bL(dataRes.recommend_forum_info);
                }
                if (dataRes.forum_create_info != null) {
                    this.fUm.a(dataRes.forum_create_info);
                }
                if (dataRes.private_forum_popinfo != null) {
                    this.fUn.a(dataRes.private_forum_popinfo);
                }
                if (dataRes.hot_search != null) {
                    this.fUo = new HotSearchInfoData();
                    this.fUo.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public g bxI() {
        return this.fUk;
    }

    public void a(g gVar) {
        this.fUk = gVar;
    }

    public void a(j jVar) {
        this.fUl = jVar;
    }

    public void a(ForumCreateInfoData forumCreateInfoData) {
        this.fUm = forumCreateInfoData;
    }

    public ForumCreateInfoData bxJ() {
        return this.fUm;
    }

    public void a(PrivateForumPopInfoData privateForumPopInfoData) {
        this.fUn = privateForumPopInfoData;
    }

    public PrivateForumPopInfoData bxK() {
        return this.fUn;
    }

    public void setIsSuccess(boolean z) {
        this.isSucc = z;
    }

    public boolean isSuccess() {
        return this.isSucc;
    }

    public boolean axB() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.NEARBY_GUIDE_TIME.longValue();
    }

    public void a(HotSearchInfoData hotSearchInfoData) {
        this.fUo = hotSearchInfoData;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }
}
