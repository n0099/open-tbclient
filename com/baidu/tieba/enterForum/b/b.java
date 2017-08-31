package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.DataRes;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class b {
    private boolean BW;
    private boolean aGa;
    private List<com.baidu.tieba.enterForum.multiConcern.b> cbD;
    private int cbE;
    private int cbF;
    private String cbG;
    private f cbH;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private h cbB = new h();
    private k cbC = new k();

    public void ej(boolean z) {
        this.aGa = z;
    }

    public b() {
        this.BW = true;
        this.BW = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void in(int i) {
        this.isLogin = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void io(int i) {
        this.cbE = i;
    }

    public void ip(int i) {
        this.cbF = i;
    }

    public void jP(String str) {
        this.cbG = str;
    }

    public f getHotSearchInfoData() {
        return this.cbH;
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
                io(dataRes.msign_valid.intValue());
                ip(dataRes.msign_level.intValue());
                in(dataRes.is_login.intValue());
                jP(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.cbB.setLevel(this.cbF);
                if (dataRes.like_forum != null) {
                    this.cbB.ao(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.cbC.ap(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.cbH = new f();
                    this.cbH.a(dataRes.hot_search);
                }
                if (!v.v(dataRes.tag_recommend_forum)) {
                    if (this.cbD == null) {
                        this.cbD = new ArrayList();
                    } else {
                        this.cbD.clear();
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
                                this.cbD.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.cbD = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h acE() {
        return this.cbB;
    }

    public void a(h hVar) {
        this.cbB = hVar;
    }

    public void a(k kVar) {
        this.cbC = kVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> acF() {
        return this.cbD;
    }

    public void an(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.cbD = list;
    }

    public void ay(boolean z) {
        this.BW = z;
    }

    public boolean isSuccess() {
        return this.BW;
    }

    public boolean acG() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.c.azD.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.c.azD.longValue();
    }

    public void a(f fVar) {
        this.cbH = fVar;
    }
}
