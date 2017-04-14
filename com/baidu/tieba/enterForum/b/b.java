package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean Cy;
    private boolean aDm;
    private i bDX;
    private int bEa;
    private int bEb;
    private String bEc;
    private d bEd;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private e bDV = new e();
    private i bDW = new i();
    private h bDY = new h();
    private c bDZ = new c();

    public void de(boolean z) {
        this.aDm = z;
    }

    public b() {
        this.Cy = true;
        this.Cy = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void hl(int i) {
        this.isLogin = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void hm(int i) {
        this.bEa = i;
    }

    public void hn(int i) {
        this.bEb = i;
    }

    public void ik(String str) {
        this.bEc = str;
    }

    public void a(h hVar) {
        this.bDY = hVar;
    }

    public h Vx() {
        return this.bDY;
    }

    public c Vy() {
        return this.bDZ;
    }

    public void a(c cVar) {
        this.bDZ = cVar;
    }

    public d getHotSearchInfoData() {
        return this.bEd;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                hm(dataRes.msign_valid.intValue());
                hn(dataRes.msign_level.intValue());
                hl(dataRes.is_login.intValue());
                ik(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bDV.setLevel(this.bEb);
                if (dataRes.like_forum != null) {
                    this.bDV.ab(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.bDW.ab(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bDY.aa(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bEd = new d();
                    this.bEd.a(dataRes.hot_search);
                }
                if (dataRes.frequently_forum_info != null) {
                    this.bDZ.aa(dataRes.frequently_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i Vz() {
        return this.bDW;
    }

    public void a(i iVar) {
        this.bDW = iVar;
    }

    public i VA() {
        return this.bDX;
    }

    public void b(i iVar) {
        this.bDX = iVar;
    }

    public e VB() {
        return this.bDV;
    }

    public void a(e eVar) {
        this.bDV = eVar;
    }

    public void aC(boolean z) {
        this.Cy = z;
    }

    public boolean isSuccess() {
        return this.Cy;
    }

    public boolean VC() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.axm.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.axm.longValue();
    }

    public void a(d dVar) {
        this.bEd = dVar;
    }
}
