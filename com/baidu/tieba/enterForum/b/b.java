package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean azj;
    private i bJi;
    private int bJl;
    private int bJm;
    private int bJn;
    private String bJo;
    private d bJp;
    private int isMem;
    private boolean vS;
    private int time = 0;
    private e bJg = new e();
    private i bJh = new i();
    private h bJj = new h();
    private c bJk = new c();

    public void dn(boolean z) {
        this.azj = z;
    }

    public b() {
        this.vS = true;
        this.vS = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void hq(int i) {
        this.bJn = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void hr(int i) {
        this.bJl = i;
    }

    public void hs(int i) {
        this.bJm = i;
    }

    public void jv(String str) {
        this.bJo = str;
    }

    public void a(h hVar) {
        this.bJj = hVar;
    }

    public h Yv() {
        return this.bJj;
    }

    public c Yw() {
        return this.bJk;
    }

    public void a(c cVar) {
        this.bJk = cVar;
    }

    public d getHotSearchInfoData() {
        return this.bJp;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                hr(dataRes.msign_valid.intValue());
                hs(dataRes.msign_level.intValue());
                hq(dataRes.is_login.intValue());
                jv(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bJg.setLevel(this.bJm);
                if (dataRes.like_forum != null) {
                    this.bJg.ai(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.bJh.ai(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bJj.ah(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bJp = new d();
                    this.bJp.a(dataRes.hot_search);
                }
                if (dataRes.frequently_forum_info != null) {
                    this.bJk.ah(dataRes.frequently_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i Yx() {
        return this.bJh;
    }

    public void a(i iVar) {
        this.bJh = iVar;
    }

    public i Yy() {
        return this.bJi;
    }

    public void b(i iVar) {
        this.bJi = iVar;
    }

    public e Yz() {
        return this.bJg;
    }

    public void a(e eVar) {
        this.bJg = eVar;
    }

    public void aA(boolean z) {
        this.vS = z;
    }

    public boolean isSuccess() {
        return this.vS;
    }

    public boolean YA() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.asT.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.asT.longValue();
    }

    public void a(d dVar) {
        this.bJp = dVar;
    }
}
