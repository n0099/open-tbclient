package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean CB;
    private boolean aDo;
    private i bGo;
    private int bGr;
    private int bGs;
    private String bGt;
    private d bGu;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private e bGm = new e();
    private i bGn = new i();
    private h bGp = new h();
    private c bGq = new c();

    /* renamed from: do  reason: not valid java name */
    public void m18do(boolean z) {
        this.aDo = z;
    }

    public b() {
        this.CB = true;
        this.CB = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void hr(int i) {
        this.isLogin = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void hs(int i) {
        this.bGr = i;
    }

    public void ht(int i) {
        this.bGs = i;
    }

    public void il(String str) {
        this.bGt = str;
    }

    public void a(h hVar) {
        this.bGp = hVar;
    }

    public h Wy() {
        return this.bGp;
    }

    public c Wz() {
        return this.bGq;
    }

    public void a(c cVar) {
        this.bGq = cVar;
    }

    public d getHotSearchInfoData() {
        return this.bGu;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                hs(dataRes.msign_valid.intValue());
                ht(dataRes.msign_level.intValue());
                hr(dataRes.is_login.intValue());
                il(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bGm.setLevel(this.bGs);
                if (dataRes.like_forum != null) {
                    this.bGm.ac(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.bGn.ac(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bGp.ab(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bGu = new d();
                    this.bGu.a(dataRes.hot_search);
                }
                if (dataRes.frequently_forum_info != null) {
                    this.bGq.ab(dataRes.frequently_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i WA() {
        return this.bGn;
    }

    public void a(i iVar) {
        this.bGn = iVar;
    }

    public i WB() {
        return this.bGo;
    }

    public void b(i iVar) {
        this.bGo = iVar;
    }

    public e WC() {
        return this.bGm;
    }

    public void a(e eVar) {
        this.bGm = eVar;
    }

    public void aC(boolean z) {
        this.CB = z;
    }

    public boolean isSuccess() {
        return this.CB;
    }

    public boolean WD() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.axo.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.axo.longValue();
    }

    public void a(d dVar) {
        this.bGu = dVar;
    }
}
