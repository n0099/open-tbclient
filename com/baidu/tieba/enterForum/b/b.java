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
    private boolean BZ;
    private boolean aFf;
    private List<com.baidu.tieba.enterForum.multiConcern.b> ccj;
    private int cck;
    private int ccl;
    private String ccm;
    private f ccn;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private h cch = new h();
    private k cci = new k();

    public void ec(boolean z) {
        this.aFf = z;
    }

    public b() {
        this.BZ = true;
        this.BZ = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void iw(int i) {
        this.isLogin = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void ix(int i) {
        this.cck = i;
    }

    public void iy(int i) {
        this.ccl = i;
    }

    public void jK(String str) {
        this.ccm = str;
    }

    public f getHotSearchInfoData() {
        return this.ccn;
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
                ix(dataRes.msign_valid.intValue());
                iy(dataRes.msign_level.intValue());
                iw(dataRes.is_login.intValue());
                jK(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.cch.setLevel(this.ccl);
                if (dataRes.like_forum != null) {
                    this.cch.an(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.cci.ao(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.ccn = new f();
                    this.ccn.a(dataRes.hot_search);
                }
                if (!v.u(dataRes.tag_recommend_forum)) {
                    if (this.ccj == null) {
                        this.ccj = new ArrayList();
                    } else {
                        this.ccj.clear();
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
                                this.ccj.add(bVar);
                                i = i2 + 1;
                            }
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.ccj = null;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h acy() {
        return this.cch;
    }

    public void a(h hVar) {
        this.cch = hVar;
    }

    public void a(k kVar) {
        this.cci = kVar;
    }

    public List<com.baidu.tieba.enterForum.multiConcern.b> acz() {
        return this.ccj;
    }

    public void am(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        this.ccj = list;
    }

    public void ax(boolean z) {
        this.BZ = z;
    }

    public boolean isSuccess() {
        return this.BZ;
    }

    public boolean acA() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.ayI.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.ayI.longValue();
    }

    public void a(f fVar) {
        this.ccn = fVar;
    }
}
