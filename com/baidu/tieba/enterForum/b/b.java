package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.DataRes;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class b {
    private boolean CB;
    private boolean aEl;
    private List<com.baidu.tieba.enterForum.multiConcern.g> bSA;
    private int bSB;
    private int bSC;
    private String bSD;
    private f bSE;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private h bSy = new h();
    private k bSz = new k();

    public void dW(boolean z) {
        this.aEl = z;
    }

    public b() {
        this.CB = true;
        this.CB = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void hU(int i) {
        this.isLogin = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void hV(int i) {
        this.bSB = i;
    }

    public void hW(int i) {
        this.bSC = i;
    }

    public void jq(String str) {
        this.bSD = str;
    }

    public f getHotSearchInfoData() {
        return this.bSE;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                hV(dataRes.msign_valid.intValue());
                hW(dataRes.msign_level.intValue());
                hU(dataRes.is_login.intValue());
                jq(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bSy.setLevel(this.bSC);
                if (dataRes.like_forum != null) {
                    this.bSy.ai(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bSz.aj(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bSE = new f();
                    this.bSE.a(dataRes.hot_search);
                }
                if (!z.t(dataRes.tag_recommend_forum)) {
                    if (this.bSA == null) {
                        this.bSA = new ArrayList();
                    } else {
                        this.bSA.clear();
                    }
                    int i = 0;
                    for (RecommendForumInfo recommendForumInfo : dataRes.tag_recommend_forum) {
                        if (i < 4) {
                            if (recommendForumInfo != null && recommendForumInfo.forum_id.longValue() > 0 && !StringUtils.isNull(recommendForumInfo.forum_name)) {
                                com.baidu.tieba.enterForum.multiConcern.g gVar = new com.baidu.tieba.enterForum.multiConcern.g();
                                gVar.avatar = recommendForumInfo.avatar;
                                gVar.forumId = recommendForumInfo.forum_id.longValue();
                                gVar.forumName = recommendForumInfo.forum_name;
                                gVar.followNum = recommendForumInfo.member_count.intValue();
                                gVar.threadNum = recommendForumInfo.thread_count.intValue();
                                gVar.isSelected = true;
                                this.bSA.add(gVar);
                                i++;
                            }
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.bSA = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h aas() {
        return this.bSy;
    }

    public void a(h hVar) {
        this.bSy = hVar;
    }

    public void a(k kVar) {
        this.bSz = kVar;
    }

    public k aat() {
        return this.bSz;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.g> aau() {
        return this.bSA;
    }

    public void ah(List<com.baidu.tieba.enterForum.multiConcern.g> list) {
        this.bSA = list;
    }

    public void az(boolean z) {
        this.CB = z;
    }

    public boolean isSuccess() {
        return this.CB;
    }

    public boolean aav() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.e.ayh.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.e.ayh.longValue();
    }

    public void a(f fVar) {
        this.bSE = fVar;
    }
}
