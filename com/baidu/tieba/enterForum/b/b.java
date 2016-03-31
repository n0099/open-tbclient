package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean CK;
    private boolean ayb;
    private h baC;
    private int baE;
    private int baF;
    private int baG;
    private String baH;
    private c baI;
    private int isMem;
    int redirect;
    private int time = 0;
    private d baA = new d();
    private h baB = new h();
    private g baD = new g();

    public int getRedirect() {
        return this.redirect;
    }

    public void gc(int i) {
        this.redirect = i;
    }

    public void ci(boolean z) {
        this.ayb = z;
    }

    public b() {
        this.CK = true;
        this.CK = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void gd(int i) {
        this.baG = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void ge(int i) {
        this.baE = i;
    }

    public void gf(int i) {
        this.baF = i;
    }

    public void hm(String str) {
        this.baH = str;
    }

    public void a(g gVar) {
        this.baD = gVar;
    }

    public g Nu() {
        return this.baD;
    }

    public c getHotSearchInfoData() {
        return this.baI;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                ge(dataRes.msign_valid.intValue());
                gf(dataRes.msign_level.intValue());
                gd(dataRes.is_login.intValue());
                hm(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.baA.setLevel(this.baF);
                if (dataRes.like_forum != null) {
                    this.baA.M(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.baB.M(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.baD.N(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.baI = new c();
                    this.baI.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h Nv() {
        return this.baB;
    }

    public void a(h hVar) {
        this.baB = hVar;
    }

    public h Nw() {
        return this.baC;
    }

    public void b(h hVar) {
        this.baC = hVar;
    }

    public d Nx() {
        return this.baA;
    }

    public void a(d dVar) {
        this.baA = dVar;
    }

    public void as(boolean z) {
        this.CK = z;
    }

    public boolean isSuccess() {
        return this.CK;
    }

    public boolean Ny() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.c.arV.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.c.arV.longValue();
    }

    public void a(c cVar) {
        this.baI = cVar;
    }
}
