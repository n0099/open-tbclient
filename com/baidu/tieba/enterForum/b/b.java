package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean Cj;
    private int aLA;
    private c aLB;
    private int aLw;
    private int aLx;
    private int aLy;
    private String aLz;
    private boolean asV;
    private int time = 0;
    private d aLt = new d();
    private h aLu = new h();
    private g aLv = new g();

    public void bM(boolean z) {
        this.asV = z;
    }

    public b() {
        this.Cj = true;
        this.Cj = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void fd(int i) {
        this.aLy = i;
    }

    public void setIsMem(int i) {
        this.aLA = i;
    }

    public void fe(int i) {
        this.aLw = i;
    }

    public void ff(int i) {
        this.aLx = i;
    }

    public void gv(String str) {
        this.aLz = str;
    }

    public void a(g gVar) {
        this.aLv = gVar;
    }

    public g Ii() {
        return this.aLv;
    }

    public c getHotSearchInfoData() {
        return this.aLB;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                fe(dataRes.msign_valid.intValue());
                ff(dataRes.msign_level.intValue());
                fd(dataRes.is_login.intValue());
                gv(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.aLt.setLevel(this.aLx);
                if (dataRes.like_forum != null) {
                    this.aLt.K(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aLu.K(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aLv.L(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.aLB = new c();
                    this.aLB.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h Ij() {
        return this.aLu;
    }

    public void a(h hVar) {
        this.aLu = hVar;
    }

    public d Ik() {
        return this.aLt;
    }

    public void a(d dVar) {
        this.aLt = dVar;
    }

    public void ap(boolean z) {
        this.Cj = z;
    }

    public boolean isSuccess() {
        return this.Cj;
    }

    public boolean Il() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.anr.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.anr.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.Cj) {
            if (this.aLt == null || this.aLt.In() == null || this.aLt.In().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }

    public void a(c cVar) {
        this.aLB = cVar;
    }
}
