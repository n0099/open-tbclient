package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean ayO;
    private i bGd;
    private int bGg;
    private int bGh;
    private int bGi;
    private String bGj;
    private d bGk;
    private int isMem;
    private boolean vS;
    private int time = 0;
    private e bGb = new e();
    private i bGc = new i();
    private h bGe = new h();
    private c bGf = new c();

    public void dh(boolean z) {
        this.ayO = z;
    }

    public b() {
        this.vS = true;
        this.vS = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void hl(int i) {
        this.bGi = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void hm(int i) {
        this.bGg = i;
    }

    public void hn(int i) {
        this.bGh = i;
    }

    public void jk(String str) {
        this.bGj = str;
    }

    public void a(h hVar) {
        this.bGe = hVar;
    }

    public h Xa() {
        return this.bGe;
    }

    public c Xb() {
        return this.bGf;
    }

    public void a(c cVar) {
        this.bGf = cVar;
    }

    public d getHotSearchInfoData() {
        return this.bGk;
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
                jk(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bGb.setLevel(this.bGh);
                if (dataRes.like_forum != null) {
                    this.bGb.ah(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.bGc.ah(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bGe.ag(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bGk = new d();
                    this.bGk.a(dataRes.hot_search);
                }
                if (dataRes.frequently_forum_info != null) {
                    this.bGf.ag(dataRes.frequently_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i Xc() {
        return this.bGc;
    }

    public void a(i iVar) {
        this.bGc = iVar;
    }

    public i Xd() {
        return this.bGd;
    }

    public void b(i iVar) {
        this.bGd = iVar;
    }

    public e Xe() {
        return this.bGb;
    }

    public void a(e eVar) {
        this.bGb = eVar;
    }

    public void ax(boolean z) {
        this.vS = z;
    }

    public boolean isSuccess() {
        return this.vS;
    }

    public boolean Xf() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.aso.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.aso.longValue();
    }

    public void a(d dVar) {
        this.bGk = dVar;
    }
}
