package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.t;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private int aLZ;
    private int aMa;
    private int aMb;
    private String aMc;
    private int aMd;
    private boolean ahA;
    private boolean atZ;
    private int time = 0;
    private c aLW = new c();
    private t aLX = new t();
    private f aLY = new f();

    public void bI(boolean z) {
        this.atZ = z;
    }

    public b() {
        this.ahA = true;
        this.ahA = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void eJ(int i) {
        this.aMb = i;
    }

    public void setIsMem(int i) {
        this.aMd = i;
    }

    public void eK(int i) {
        this.aLZ = i;
    }

    public void eL(int i) {
        this.aMa = i;
    }

    public void gj(String str) {
        this.aMc = str;
    }

    public void a(f fVar) {
        this.aLY = fVar;
    }

    public f Io() {
        return this.aLY;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                eK(dataRes.msign_valid.intValue());
                eL(dataRes.msign_level.intValue());
                eJ(dataRes.is_login.intValue());
                gj(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.aLW.setLevel(this.aMa);
                if (dataRes.like_forum != null) {
                    this.aLW.j(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aLX.j(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aLY.H(dataRes.recommend_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public t Ip() {
        return this.aLX;
    }

    public void a(t tVar) {
        this.aLX = tVar;
    }

    public c Iq() {
        return this.aLW;
    }

    public void a(c cVar) {
        this.aLW = cVar;
    }

    public void ap(boolean z) {
        this.ahA = z;
    }

    public boolean isSuccess() {
        return this.ahA;
    }

    public boolean Ir() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.amX.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.amX.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.ahA) {
            if (this.aLW == null || this.aLW.Is() == null || this.aLW.Is().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }
}
