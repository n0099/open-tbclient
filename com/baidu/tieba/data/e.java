package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.data.b;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class e {
    private boolean QO;
    private boolean abl;
    private int arS;
    private int arT;
    private int arU;
    private String arV;
    private int arW;
    private int time = 0;
    private j arO = new j();
    private o arP = new o();
    private v arQ = new v();
    private n arR = new n();

    public boolean BY() {
        return this.abl;
    }

    public void bn(boolean z) {
        this.abl = z;
    }

    public e() {
        this.QO = true;
        this.QO = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void en(int i) {
        this.arU = i;
    }

    public void setIsMem(int i) {
        this.arW = i;
    }

    public int BZ() {
        return this.arS;
    }

    public void eo(int i) {
        this.arS = i;
    }

    public int Ca() {
        return this.arT;
    }

    public void ep(int i) {
        this.arT = i;
    }

    public String Cb() {
        return this.arV;
    }

    public void eW(String str) {
        this.arV = str;
    }

    public void a(n nVar) {
        this.arR = nVar;
    }

    public n Cc() {
        return this.arR;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                eo(dataRes.msign_valid.intValue());
                ep(dataRes.msign_level.intValue());
                en(dataRes.is_login.intValue());
                eW(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.arO.setLevel(this.arT);
                if (dataRes.like_forum != null) {
                    this.arO.i(dataRes.like_forum);
                }
                if (dataRes.new_recommend != null) {
                    this.arP.i(dataRes.new_recommend);
                }
                if (dataRes.banner != null) {
                    this.arQ.i(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.arR.F(dataRes.recommend_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public v Cd() {
        return this.arQ;
    }

    public void a(v vVar) {
        this.arQ = vVar;
    }

    public j Ce() {
        return this.arO;
    }

    public void a(j jVar) {
        this.arO = jVar;
    }

    public o Cf() {
        return this.arP;
    }

    public void a(o oVar) {
        this.arP = oVar;
    }

    public void as(boolean z) {
        this.QO = z;
    }

    public boolean isSuccess() {
        return this.QO;
    }

    public boolean Cg() {
        return System.currentTimeMillis() / b.Wa.longValue() == (((long) this.time) * 1000) / b.Wa.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.QO) {
            if (this.arO == null || this.arO.Cu() == null || this.arO.Cu().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }

    public boolean Ch() {
        if (this.arO != null) {
            return this.arO.Ch();
        }
        return false;
    }
}
