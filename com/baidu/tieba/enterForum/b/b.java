package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.v;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean Ci;
    private int aMm;
    private int aMn;
    private int aMo;
    private String aMp;
    private int aMq;
    private boolean avJ;
    private int time = 0;
    private c aMj = new c();
    private v aMk = new v();
    private f aMl = new f();

    public void bN(boolean z) {
        this.avJ = z;
    }

    public b() {
        this.Ci = true;
        this.Ci = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void eQ(int i) {
        this.aMo = i;
    }

    public void setIsMem(int i) {
        this.aMq = i;
    }

    public void eR(int i) {
        this.aMm = i;
    }

    public void eS(int i) {
        this.aMn = i;
    }

    public void gq(String str) {
        this.aMp = str;
    }

    public void a(f fVar) {
        this.aMl = fVar;
    }

    public f Ic() {
        return this.aMl;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                eR(dataRes.msign_valid.intValue());
                eS(dataRes.msign_level.intValue());
                eQ(dataRes.is_login.intValue());
                gq(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.aMj.setLevel(this.aMn);
                if (dataRes.like_forum != null) {
                    this.aMj.k(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aMk.k(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aMl.I(dataRes.recommend_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public v Id() {
        return this.aMk;
    }

    public void a(v vVar) {
        this.aMk = vVar;
    }

    public c Ie() {
        return this.aMj;
    }

    public void a(c cVar) {
        this.aMj = cVar;
    }

    public void ap(boolean z) {
        this.Ci = z;
    }

    public boolean isSuccess() {
        return this.Ci;
    }

    public boolean If() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.aoJ.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.aoJ.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.Ci) {
            if (this.aMj == null || this.aMj.Ig() == null || this.aMj.Ig().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }
}
