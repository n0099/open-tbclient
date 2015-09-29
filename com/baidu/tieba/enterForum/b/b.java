package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean Cj;
    private int aLd;
    private int aLe;
    private int aLf;
    private String aLg;
    private int aLh;
    private c aLi;
    private boolean aug;
    private int time = 0;
    private d aLa = new d();
    private h aLb = new h();
    private g aLc = new g();

    public void bK(boolean z) {
        this.aug = z;
    }

    public b() {
        this.Cj = true;
        this.Cj = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void eV(int i) {
        this.aLf = i;
    }

    public void setIsMem(int i) {
        this.aLh = i;
    }

    public void eW(int i) {
        this.aLd = i;
    }

    public void eX(int i) {
        this.aLe = i;
    }

    public void gt(String str) {
        this.aLg = str;
    }

    public void a(g gVar) {
        this.aLc = gVar;
    }

    public g HW() {
        return this.aLc;
    }

    public c getHotSearchInfoData() {
        return this.aLi;
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
                this.aLa.setLevel(this.aLe);
                if (dataRes.like_forum != null) {
                    this.aLa.I(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aLb.I(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aLc.J(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.aLi = new c();
                    this.aLi.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h HX() {
        return this.aLb;
    }

    public void a(h hVar) {
        this.aLb = hVar;
    }

    public d HY() {
        return this.aLa;
    }

    public void a(d dVar) {
        this.aLa = dVar;
    }

    public void ap(boolean z) {
        this.Cj = z;
    }

    public boolean isSuccess() {
        return this.Cj;
    }

    public boolean HZ() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.anl.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.anl.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.Cj) {
            if (this.aLa == null || this.aLa.Ib() == null || this.aLa.Ib().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }

    public void a(c cVar) {
        this.aLi = cVar;
    }
}
