package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.v;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private int aEA;
    private int aEB;
    private int aEC;
    private String aED;
    private int aEE;
    private boolean acq;
    private boolean amu;
    private int time = 0;
    private c aEx = new c();
    private v aEy = new v();
    private f aEz = new f();

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
        this.aEC = i;
    }

    public void setIsMem(int i) {
        this.aEE = i;
    }

    public int Hz() {
        return this.aEA;
    }

    public void eE(int i) {
        this.aEA = i;
    }

    public int HA() {
        return this.aEB;
    }

    public void eF(int i) {
        this.aEB = i;
    }

    public String HB() {
        return this.aED;
    }

    public void fQ(String str) {
        this.aED = str;
    }

    public void a(f fVar) {
        this.aEz = fVar;
    }

    public f HC() {
        return this.aEz;
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
                this.aEx.setLevel(this.aEB);
                if (dataRes.like_forum != null) {
                    this.aEx.j(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aEy.j(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aEz.I(dataRes.recommend_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public v HD() {
        return this.aEy;
    }

    public void a(v vVar) {
        this.aEy = vVar;
    }

    public c HE() {
        return this.aEx;
    }

    public void a(c cVar) {
        this.aEx = cVar;
    }

    public void al(boolean z) {
        this.acq = z;
    }

    public boolean isSuccess() {
        return this.acq;
    }

    public boolean HF() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.ahR.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.ahR.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.acq) {
            if (this.aEx == null || this.aEx.HH() == null || this.aEx.HH().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }

    public boolean HG() {
        if (this.aEx != null) {
            return this.aEx.HG();
        }
        return false;
    }
}
