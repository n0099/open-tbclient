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
    private boolean Ea;
    private boolean aGG;
    private List<com.baidu.tieba.enterForum.multiConcern.b> bXU;
    private int bXV;
    private int bXW;
    private String bXX;
    private f bXY;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private h bXS = new h();
    private k bXT = new k();

    public void ef(boolean z) {
        this.aGG = z;
    }

    public b() {
        this.Ea = true;
        this.Ea = false;
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
        this.bXV = i;
    }

    public void id(int i) {
        this.bXW = i;
    }

    public void jA(String str) {
        this.bXX = str;
    }

    public f getHotSearchInfoData() {
        return this.bXY;
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
                jA(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bXS.setLevel(this.bXW);
                if (dataRes.like_forum != null) {
                    this.bXS.ao(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bXT.ap(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bXY = new f();
                    this.bXY.a(dataRes.hot_search);
                }
                if (!u.v(dataRes.tag_recommend_forum)) {
                    if (this.bXU == null) {
                        this.bXU = new ArrayList();
                    } else {
                        this.bXU.clear();
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
                                this.bXU.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.bXU = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h abj() {
        return this.bXS;
    }

    public void a(h hVar) {
        this.bXS = hVar;
    }

    public void a(k kVar) {
        this.bXT = kVar;
    }

    public k abk() {
        return this.bXT;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> abl() {
        return this.bXU;
    }

    public void an(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.bXU = list;
    }

    public void ay(boolean z) {
        this.Ea = z;
    }

    public boolean isSuccess() {
        return this.Ea;
    }

    public boolean abm() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.c.aAq.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.c.aAq.longValue();
    }

    public void a(f fVar) {
        this.bXY = fVar;
    }
}
