package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.v;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private int aEA;
    private int aEB;
    private String aEC;
    private int aED;
    private int aEz;
    private boolean acq;
    private boolean amu;
    private int time = 0;
    private c aEw = new c();
    private v aEx = new v();
    private f aEy = new f();

    public void bG(boolean z) {
        this.amu = z;
    }

    public b() {
        this.acq = true;
        this.acq = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void eD(int i) {
        this.aEB = i;
    }

    public void setIsMem(int i) {
        this.aED = i;
    }

    public int Hy() {
        return this.aEz;
    }

    public void eE(int i) {
        this.aEz = i;
    }

    public int Hz() {
        return this.aEA;
    }

    public void eF(int i) {
        this.aEA = i;
    }

    public String HA() {
        return this.aEC;
    }

    public void fQ(String str) {
        this.aEC = str;
    }

    public void a(f fVar) {
        this.aEy = fVar;
    }

    public f HB() {
        return this.aEy;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                eE(dataRes.msign_valid.intValue());
                eF(dataRes.msign_level.intValue());
                eD(dataRes.is_login.intValue());
                fQ(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.aEw.setLevel(this.aEA);
                if (dataRes.like_forum != null) {
                    this.aEw.j(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aEx.j(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aEy.I(dataRes.recommend_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public v HC() {
        return this.aEx;
    }

    public void a(v vVar) {
        this.aEx = vVar;
    }

    public c HD() {
        return this.aEw;
    }

    public void a(c cVar) {
        this.aEw = cVar;
    }

    public void al(boolean z) {
        this.acq = z;
    }

    public boolean isSuccess() {
        return this.acq;
    }

    public boolean HE() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.ahR.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.ahR.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.acq) {
            if (this.aEw == null || this.aEw.HG() == null || this.aEw.HG().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }

    public boolean HF() {
        if (this.aEw != null) {
            return this.aEw.HF();
        }
        return false;
    }
}
