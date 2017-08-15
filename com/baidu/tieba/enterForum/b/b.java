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
    private boolean aGH;
    private List<com.baidu.tieba.enterForum.multiConcern.b> bYG;
    private int bYH;
    private int bYI;
    private String bYJ;
    private f bYK;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private h bYE = new h();
    private k bYF = new k();

    public void eg(boolean z) {
        this.aGH = z;
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
        this.bYH = i;
    }

    /* renamed from: if  reason: not valid java name */
    public void m11if(int i) {
        this.bYI = i;
    }

    public void jC(String str) {
        this.bYJ = str;
    }

    public f getHotSearchInfoData() {
        return this.bYK;
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
                jC(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bYE.setLevel(this.bYI);
                if (dataRes.like_forum != null) {
                    this.bYE.ao(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bYF.ap(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bYK = new f();
                    this.bYK.a(dataRes.hot_search);
                }
                if (!u.v(dataRes.tag_recommend_forum)) {
                    if (this.bYG == null) {
                        this.bYG = new ArrayList();
                    } else {
                        this.bYG.clear();
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
                                this.bYG.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.bYG = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h abE() {
        return this.bYE;
    }

    public void a(h hVar) {
        this.bYE = hVar;
    }

    public void a(k kVar) {
        this.bYF = kVar;
    }

    public k abF() {
        return this.bYF;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> abG() {
        return this.bYG;
    }

    public void an(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.bYG = list;
    }

    public void ay(boolean z) {
        this.Ec = z;
    }

    public boolean isSuccess() {
        return this.Ec;
    }

    public boolean abH() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.c.aAr.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.c.aAr.longValue();
    }

    public void a(f fVar) {
        this.bYK = fVar;
    }
}
