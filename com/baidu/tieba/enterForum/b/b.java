package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.DataRes;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class b {
    private boolean Ec;
    private boolean aGI;
    private List<com.baidu.tieba.enterForum.multiConcern.b> bYH;
    private int bYI;
    private int bYJ;
    private String bYK;
    private f bYL;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private h bYF = new h();
    private k bYG = new k();

    public void eg(boolean z) {
        this.aGI = z;
    }

    public b() {
        this.Ec = true;
        this.Ec = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void id(int i) {
        this.isLogin = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void ie(int i) {
        this.bYI = i;
    }

    /* renamed from: if  reason: not valid java name */
    public void m11if(int i) {
        this.bYJ = i;
    }

    public void jF(String str) {
        this.bYK = str;
    }

    public f getHotSearchInfoData() {
        return this.bYL;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        int i;
        if (dataRes != null) {
            try {
                ie(dataRes.msign_valid.intValue());
                m11if(dataRes.msign_level.intValue());
                id(dataRes.is_login.intValue());
                jF(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bYF.setLevel(this.bYJ);
                if (dataRes.like_forum != null) {
                    this.bYF.ao(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bYG.ap(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bYL = new f();
                    this.bYL.a(dataRes.hot_search);
                }
                if (!u.v(dataRes.tag_recommend_forum)) {
                    if (this.bYH == null) {
                        this.bYH = new ArrayList();
                    } else {
                        this.bYH.clear();
                    }
                    int i2 = 0;
                    for (RecommendForumInfo recommendForumInfo : dataRes.tag_recommend_forum) {
                        if (i2 < 4) {
                            if (recommendForumInfo == null || recommendForumInfo.forum_id.longValue() <= 0 || StringUtils.isNull(recommendForumInfo.forum_name)) {
                                i = i2;
                            } else {
                                com.baidu.tieba.enterForum.multiConcern.b bVar = new com.baidu.tieba.enterForum.multiConcern.b();
                                bVar.avatar = recommendForumInfo.avatar;
                                bVar.forumId = recommendForumInfo.forum_id.longValue();
                                bVar.forumName = recommendForumInfo.forum_name;
                                bVar.followNum = recommendForumInfo.member_count.intValue();
                                bVar.threadNum = recommendForumInfo.thread_count.intValue();
                                bVar.isSelected = true;
                                this.bYH.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.bYH = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h abB() {
        return this.bYF;
    }

    public void a(h hVar) {
        this.bYF = hVar;
    }

    public void a(k kVar) {
        this.bYG = kVar;
    }

    public k abC() {
        return this.bYG;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> abD() {
        return this.bYH;
    }

    public void an(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.bYH = list;
    }

    public void ay(boolean z) {
        this.Ec = z;
    }

    public boolean isSuccess() {
        return this.Ec;
    }

    public boolean abE() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.c.aAs.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.c.aAs.longValue();
    }

    public void a(f fVar) {
        this.bYL = fVar;
    }
}
