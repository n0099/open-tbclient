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
    private boolean CB;
    private boolean aFq;
    private List<com.baidu.tieba.enterForum.multiConcern.b> bWO;
    private int bWP;
    private int bWQ;
    private String bWR;
    private f bWS;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private h bWM = new h();
    private k bWN = new k();

    public void ef(boolean z) {
        this.aFq = z;
    }

    public b() {
        this.CB = true;
        this.CB = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void ib(int i) {
        this.isLogin = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void ic(int i) {
        this.bWP = i;
    }

    public void id(int i) {
        this.bWQ = i;
    }

    public void jw(String str) {
        this.bWR = str;
    }

    public f getHotSearchInfoData() {
        return this.bWS;
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
                ic(dataRes.msign_valid.intValue());
                id(dataRes.msign_level.intValue());
                ib(dataRes.is_login.intValue());
                jw(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bWM.setLevel(this.bWQ);
                if (dataRes.like_forum != null) {
                    this.bWM.ao(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bWN.ap(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bWS = new f();
                    this.bWS.a(dataRes.hot_search);
                }
                if (!u.v(dataRes.tag_recommend_forum)) {
                    if (this.bWO == null) {
                        this.bWO = new ArrayList();
                    } else {
                        this.bWO.clear();
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
                                this.bWO.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.bWO = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h abe() {
        return this.bWM;
    }

    public void a(h hVar) {
        this.bWM = hVar;
    }

    public void a(k kVar) {
        this.bWN = kVar;
    }

    public k abf() {
        return this.bWN;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> abg() {
        return this.bWO;
    }

    public void an(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.bWO = list;
    }

    public void ay(boolean z) {
        this.CB = z;
    }

    public boolean isSuccess() {
        return this.CB;
    }

    public boolean abh() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.c.ayZ.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.c.ayZ.longValue();
    }

    public void a(f fVar) {
        this.bWS = fVar;
    }
}
