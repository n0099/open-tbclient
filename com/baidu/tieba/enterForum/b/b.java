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
    private boolean aFX;
    private List<com.baidu.tieba.enterForum.multiConcern.b> ccv;
    private int ccw;
    private int ccx;
    private String ccy;
    private f ccz;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private h cct = new h();
    private k ccu = new k();

    public void ek(boolean z) {
        this.aFX = z;
    }

    public b() {
        this.BW = true;
        this.BW = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void ip(int i) {
        this.isLogin = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void iq(int i) {
        this.ccw = i;
    }

    public void ir(int i) {
        this.ccx = i;
    }

    public void jR(String str) {
        this.ccy = str;
    }

    public f getHotSearchInfoData() {
        return this.ccz;
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
                iq(dataRes.msign_valid.intValue());
                ir(dataRes.msign_level.intValue());
                ip(dataRes.is_login.intValue());
                jR(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.cct.setLevel(this.ccx);
                if (dataRes.like_forum != null) {
                    this.cct.ao(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.ccu.ap(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.ccz = new f();
                    this.ccz.a(dataRes.hot_search);
                }
                if (!v.v(dataRes.tag_recommend_forum)) {
                    if (this.ccv == null) {
                        this.ccv = new ArrayList();
                    } else {
                        this.ccv.clear();
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
                                this.ccv.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.ccv = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h acP() {
        return this.cct;
    }

    public void a(h hVar) {
        this.cct = hVar;
    }

    public void a(k kVar) {
        this.ccu = kVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> acQ() {
        return this.ccv;
    }

    public void an(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.ccv = list;
    }

    public void ay(boolean z) {
        this.BW = z;
    }

    public boolean isSuccess() {
        return this.BW;
    }

    public boolean acR() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.c.azA.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.c.azA.longValue();
    }

    public void a(f fVar) {
        this.ccz = fVar;
    }
}
