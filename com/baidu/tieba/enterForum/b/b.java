package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private h aWF;
    private int aWH;
    private int aWI;
    private int aWJ;
    private String aWK;
    private c aWL;
    private boolean auc;
    private int isMem;
    int redirect;
    private boolean sZ;
    private int time = 0;
    private d aWD = new d();
    private h aWE = new h();
    private g aWG = new g();

    public int getRedirect() {
        return this.redirect;
    }

    public void fI(int i) {
        this.redirect = i;
    }

    public void cp(boolean z) {
        this.auc = z;
    }

    public b() {
        this.sZ = true;
        this.sZ = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void fJ(int i) {
        this.aWJ = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void fK(int i) {
        this.aWH = i;
    }

    public void fL(int i) {
        this.aWI = i;
    }

    public void hm(String str) {
        this.aWK = str;
    }

    public void a(g gVar) {
        this.aWG = gVar;
    }

    public g Mf() {
        return this.aWG;
    }

    public c getHotSearchInfoData() {
        return this.aWL;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                fK(dataRes.msign_valid.intValue());
                fL(dataRes.msign_level.intValue());
                fJ(dataRes.is_login.intValue());
                hm(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.aWD.setLevel(this.aWI);
                if (dataRes.like_forum != null) {
                    this.aWD.N(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aWE.N(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aWG.O(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.aWL = new c();
                    this.aWL.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h Mg() {
        return this.aWE;
    }

    public void a(h hVar) {
        this.aWE = hVar;
    }

    public h Mh() {
        return this.aWF;
    }

    public void b(h hVar) {
        this.aWF = hVar;
    }

    public d Mi() {
        return this.aWD;
    }

    public void a(d dVar) {
        this.aWD = dVar;
    }

    public void av(boolean z) {
        this.sZ = z;
    }

    public boolean isSuccess() {
        return this.sZ;
    }

    public boolean Mj() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.anL.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.anL.longValue();
    }

    public void a(c cVar) {
        this.aWL = cVar;
    }
}
