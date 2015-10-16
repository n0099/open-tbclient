package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean Cj;
    private int aLo;
    private int aLp;
    private int aLq;
    private String aLr;
    private int aLs;
    private c aLt;
    private boolean auh;
    private int time = 0;
    private d aLl = new d();
    private h aLm = new h();
    private g aLn = new g();

    public void bK(boolean z) {
        this.auh = z;
    }

    public b() {
        this.Cj = true;
        this.Cj = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void eV(int i) {
        this.aLq = i;
    }

    public void setIsMem(int i) {
        this.aLs = i;
    }

    public void eW(int i) {
        this.aLo = i;
    }

    public void eX(int i) {
        this.aLp = i;
    }

    public void gt(String str) {
        this.aLr = str;
    }

    public void a(g gVar) {
        this.aLn = gVar;
    }

    public g HW() {
        return this.aLn;
    }

    public c getHotSearchInfoData() {
        return this.aLt;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                eW(dataRes.msign_valid.intValue());
                eX(dataRes.msign_level.intValue());
                eV(dataRes.is_login.intValue());
                gt(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.aLl.setLevel(this.aLp);
                if (dataRes.like_forum != null) {
                    this.aLl.I(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aLm.I(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aLn.J(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.aLt = new c();
                    this.aLt.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h HX() {
        return this.aLm;
    }

    public void a(h hVar) {
        this.aLm = hVar;
    }

    public d HY() {
        return this.aLl;
    }

    public void a(d dVar) {
        this.aLl = dVar;
    }

    public void ap(boolean z) {
        this.Cj = z;
    }

    public boolean isSuccess() {
        return this.Cj;
    }

    public boolean HZ() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.anm.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.anm.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.Cj) {
            if (this.aLl == null || this.aLl.Ib() == null || this.aLl.Ib().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }

    public void a(c cVar) {
        this.aLt = cVar;
    }
}
