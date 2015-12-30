package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean Cv;
    private int aTO;
    private int aTP;
    private int aTQ;
    private String aTR;
    private c aTS;
    private boolean awD;
    private int isMem;
    int redirect;
    private int time = 0;
    private d aTL = new d();
    private h aTM = new h();
    private g aTN = new g();

    public int getRedirect() {
        return this.redirect;
    }

    public void fn(int i) {
        this.redirect = i;
    }

    public void bY(boolean z) {
        this.awD = z;
    }

    public b() {
        this.Cv = true;
        this.Cv = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void fo(int i) {
        this.aTQ = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void fp(int i) {
        this.aTO = i;
    }

    public void fq(int i) {
        this.aTP = i;
    }

    public void gV(String str) {
        this.aTR = str;
    }

    public void a(g gVar) {
        this.aTN = gVar;
    }

    public g JS() {
        return this.aTN;
    }

    public c getHotSearchInfoData() {
        return this.aTS;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                fp(dataRes.msign_valid.intValue());
                fq(dataRes.msign_level.intValue());
                fo(dataRes.is_login.intValue());
                gV(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.aTL.setLevel(this.aTP);
                if (dataRes.like_forum != null) {
                    this.aTL.L(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aTM.L(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aTN.M(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.aTS = new c();
                    this.aTS.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(h hVar) {
        this.aTM = hVar;
    }

    public d JT() {
        return this.aTL;
    }

    public void a(d dVar) {
        this.aTL = dVar;
    }

    public void ap(boolean z) {
        this.Cv = z;
    }

    public boolean isSuccess() {
        return this.Cv;
    }

    public boolean JU() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.aqJ.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.aqJ.longValue();
    }

    public void a(c cVar) {
        this.aTS = cVar;
    }
}
