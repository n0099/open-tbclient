package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean axC;
    private i bwY;
    private int bxb;
    private int bxc;
    private String bxd;
    private d bxe;
    private int isLogin;
    private int isMem;
    private boolean vJ;
    private int time = 0;
    private e bwW = new e();
    private i bwX = new i();
    private h bwZ = new h();
    private c bxa = new c();

    public void dc(boolean z) {
        this.axC = z;
    }

    public b() {
        this.vJ = true;
        this.vJ = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void hm(int i) {
        this.isLogin = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void hn(int i) {
        this.bxb = i;
    }

    public void ho(int i) {
        this.bxc = i;
    }

    public void iq(String str) {
        this.bxd = str;
    }

    public void a(h hVar) {
        this.bwZ = hVar;
    }

    public h Ub() {
        return this.bwZ;
    }

    public c Uc() {
        return this.bxa;
    }

    public void a(c cVar) {
        this.bxa = cVar;
    }

    public d getHotSearchInfoData() {
        return this.bxe;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                hn(dataRes.msign_valid.intValue());
                ho(dataRes.msign_level.intValue());
                hm(dataRes.is_login.intValue());
                iq(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bwW.setLevel(this.bxc);
                if (dataRes.like_forum != null) {
                    this.bwW.ae(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.bwX.ae(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bwZ.ad(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bxe = new d();
                    this.bxe.a(dataRes.hot_search);
                }
                if (dataRes.frequently_forum_info != null) {
                    this.bxa.ad(dataRes.frequently_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i Ud() {
        return this.bwX;
    }

    public void a(i iVar) {
        this.bwX = iVar;
    }

    public i Ue() {
        return this.bwY;
    }

    public void b(i iVar) {
        this.bwY = iVar;
    }

    public e Uf() {
        return this.bwW;
    }

    public void a(e eVar) {
        this.bwW = eVar;
    }

    public void aB(boolean z) {
        this.vJ = z;
    }

    public boolean isSuccess() {
        return this.vJ;
    }

    public boolean Ug() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.arB.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.arB.longValue();
    }

    public void a(d dVar) {
        this.bxe = dVar;
    }
}
