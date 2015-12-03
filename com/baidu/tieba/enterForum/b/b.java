package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean Cq;
    private int aPW;
    private int aPX;
    private int aPY;
    private String aPZ;
    private c aQa;
    private boolean auZ;
    private int isMem;
    int redirect;
    private int time = 0;
    private d aPT = new d();
    private h aPU = new h();
    private g aPV = new g();

    public int getRedirect() {
        return this.redirect;
    }

    public void fs(int i) {
        this.redirect = i;
    }

    public void bX(boolean z) {
        this.auZ = z;
    }

    public b() {
        this.Cq = true;
        this.Cq = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void ft(int i) {
        this.aPY = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void fu(int i) {
        this.aPW = i;
    }

    public void fv(int i) {
        this.aPX = i;
    }

    public void gL(String str) {
        this.aPZ = str;
    }

    public void a(g gVar) {
        this.aPV = gVar;
    }

    public g JB() {
        return this.aPV;
    }

    public c getHotSearchInfoData() {
        return this.aQa;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                fu(dataRes.msign_valid.intValue());
                fv(dataRes.msign_level.intValue());
                ft(dataRes.is_login.intValue());
                gL(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.aPT.setLevel(this.aPX);
                if (dataRes.like_forum != null) {
                    this.aPT.K(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aPU.K(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aPV.L(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.aQa = new c();
                    this.aQa.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(h hVar) {
        this.aPU = hVar;
    }

    public d JC() {
        return this.aPT;
    }

    public void a(d dVar) {
        this.aPT = dVar;
    }

    public void as(boolean z) {
        this.Cq = z;
    }

    public boolean isSuccess() {
        return this.Cq;
    }

    public boolean JD() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.apf.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.apf.longValue();
    }

    public void a(c cVar) {
        this.aQa = cVar;
    }
}
