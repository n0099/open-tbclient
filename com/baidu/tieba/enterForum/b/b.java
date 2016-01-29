package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean CF;
    private h aVT;
    private int aVV;
    private int aVW;
    private int aVX;
    private String aVY;
    private c aVZ;
    private boolean axu;
    private int isMem;
    int redirect;
    private int time = 0;
    private d aVR = new d();
    private h aVS = new h();
    private g aVU = new g();

    public int getRedirect() {
        return this.redirect;
    }

    public void fM(int i) {
        this.redirect = i;
    }

    public void bW(boolean z) {
        this.axu = z;
    }

    public b() {
        this.CF = true;
        this.CF = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void fN(int i) {
        this.aVX = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void fO(int i) {
        this.aVV = i;
    }

    public void fP(int i) {
        this.aVW = i;
    }

    public void gW(String str) {
        this.aVY = str;
    }

    public void a(g gVar) {
        this.aVU = gVar;
    }

    public g LG() {
        return this.aVU;
    }

    public c getHotSearchInfoData() {
        return this.aVZ;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                fO(dataRes.msign_valid.intValue());
                fP(dataRes.msign_level.intValue());
                fN(dataRes.is_login.intValue());
                gW(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.aVR.setLevel(this.aVW);
                if (dataRes.like_forum != null) {
                    this.aVR.I(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aVS.I(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aVU.J(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.aVZ = new c();
                    this.aVZ.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h LH() {
        return this.aVS;
    }

    public void a(h hVar) {
        this.aVS = hVar;
    }

    public h LI() {
        return this.aVT;
    }

    public void b(h hVar) {
        this.aVT = hVar;
    }

    public d LJ() {
        return this.aVR;
    }

    public void a(d dVar) {
        this.aVR = dVar;
    }

    public void aq(boolean z) {
        this.CF = z;
    }

    public boolean isSuccess() {
        return this.CF;
    }

    public boolean LK() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.arC.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.arC.longValue();
    }

    public void a(c cVar) {
        this.aVZ = cVar;
    }
}
