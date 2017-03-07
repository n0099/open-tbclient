package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean CX;
    private boolean aCW;
    private i bEe;
    private int bEh;
    private int bEi;
    private String bEj;
    private d bEk;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private e bEc = new e();
    private i bEd = new i();
    private h bEf = new h();
    private c bEg = new c();

    public void dc(boolean z) {
        this.aCW = z;
    }

    public b() {
        this.CX = true;
        this.CX = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void hi(int i) {
        this.isLogin = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void hj(int i) {
        this.bEh = i;
    }

    public void hk(int i) {
        this.bEi = i;
    }

    public void ig(String str) {
        this.bEj = str;
    }

    public void a(h hVar) {
        this.bEf = hVar;
    }

    public h UZ() {
        return this.bEf;
    }

    public c Va() {
        return this.bEg;
    }

    public void a(c cVar) {
        this.bEg = cVar;
    }

    public d getHotSearchInfoData() {
        return this.bEk;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                hj(dataRes.msign_valid.intValue());
                hk(dataRes.msign_level.intValue());
                hi(dataRes.is_login.intValue());
                ig(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bEc.setLevel(this.bEi);
                if (dataRes.like_forum != null) {
                    this.bEc.ab(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.bEd.ab(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bEf.aa(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bEk = new d();
                    this.bEk.a(dataRes.hot_search);
                }
                if (dataRes.frequently_forum_info != null) {
                    this.bEg.aa(dataRes.frequently_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i Vb() {
        return this.bEd;
    }

    public void a(i iVar) {
        this.bEd = iVar;
    }

    public i Vc() {
        return this.bEe;
    }

    public void b(i iVar) {
        this.bEe = iVar;
    }

    public e Vd() {
        return this.bEc;
    }

    public void a(e eVar) {
        this.bEc = eVar;
    }

    public void aA(boolean z) {
        this.CX = z;
    }

    public boolean isSuccess() {
        return this.CX;
    }

    public boolean Ve() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.awW.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.awW.longValue();
    }

    public void a(d dVar) {
        this.bEk = dVar;
    }
}
