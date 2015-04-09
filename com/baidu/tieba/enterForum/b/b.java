package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.v;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private String aCA;
    private int aCB;
    private int aCx;
    private int aCy;
    private int aCz;
    private boolean abm;
    private boolean alt;
    private int time = 0;
    private c aCu = new c();
    private v aCv = new v();
    private e aCw = new e();

    public void bw(boolean z) {
        this.alt = z;
    }

    public b() {
        this.abm = true;
        this.abm = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void er(int i) {
        this.aCz = i;
    }

    public void setIsMem(int i) {
        this.aCB = i;
    }

    public int Gu() {
        return this.aCx;
    }

    public void es(int i) {
        this.aCx = i;
    }

    public int Gv() {
        return this.aCy;
    }

    public void et(int i) {
        this.aCy = i;
    }

    public String Gw() {
        return this.aCA;
    }

    public void fq(String str) {
        this.aCA = str;
    }

    public void a(e eVar) {
        this.aCw = eVar;
    }

    public e Gx() {
        return this.aCw;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                es(dataRes.msign_valid.intValue());
                et(dataRes.msign_level.intValue());
                er(dataRes.is_login.intValue());
                fq(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.aCu.setLevel(this.aCy);
                if (dataRes.like_forum != null) {
                    this.aCu.i(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aCv.i(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aCw.F(dataRes.recommend_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public v Gy() {
        return this.aCv;
    }

    public void a(v vVar) {
        this.aCv = vVar;
    }

    public c Gz() {
        return this.aCu;
    }

    public void a(c cVar) {
        this.aCu = cVar;
    }

    public void af(boolean z) {
        this.abm = z;
    }

    public boolean isSuccess() {
        return this.abm;
    }

    public boolean GA() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.agQ.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.agQ.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.abm) {
            if (this.aCu == null || this.aCu.GC() == null || this.aCu.GC().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }

    public boolean GB() {
        if (this.aCu != null) {
            return this.aCu.GB();
        }
        return false;
    }
}
