package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean auS;
    private i bsB;
    private int bsE;
    private int bsF;
    private int bsG;
    private String bsH;
    private d bsI;
    private int isMem;
    private boolean tb;
    private int time = 0;
    private e bsz = new e();
    private i bsA = new i();
    private h bsC = new h();
    private c bsD = new c();

    public void cK(boolean z) {
        this.auS = z;
    }

    public b() {
        this.tb = true;
        this.tb = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void gJ(int i) {
        this.bsG = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void gK(int i) {
        this.bsE = i;
    }

    public void gL(int i) {
        this.bsF = i;
    }

    public void iv(String str) {
        this.bsH = str;
    }

    public void a(h hVar) {
        this.bsC = hVar;
    }

    public h RH() {
        return this.bsC;
    }

    public c RI() {
        return this.bsD;
    }

    public void a(c cVar) {
        this.bsD = cVar;
    }

    public d getHotSearchInfoData() {
        return this.bsI;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                gK(dataRes.msign_valid.intValue());
                gL(dataRes.msign_level.intValue());
                gJ(dataRes.is_login.intValue());
                iv(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bsz.setLevel(this.bsF);
                if (dataRes.like_forum != null) {
                    this.bsz.aa(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.bsA.aa(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bsC.Z(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bsI = new d();
                    this.bsI.a(dataRes.hot_search);
                }
                if (dataRes.frequently_forum_info != null) {
                    this.bsD.Z(dataRes.frequently_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i RJ() {
        return this.bsA;
    }

    public void a(i iVar) {
        this.bsA = iVar;
    }

    public i RK() {
        return this.bsB;
    }

    public void b(i iVar) {
        this.bsB = iVar;
    }

    public e RL() {
        return this.bsz;
    }

    public void a(e eVar) {
        this.bsz = eVar;
    }

    public void at(boolean z) {
        this.tb = z;
    }

    public boolean isSuccess() {
        return this.tb;
    }

    public boolean RM() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.aos.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.aos.longValue();
    }

    public void a(d dVar) {
        this.bsI = dVar;
    }
}
