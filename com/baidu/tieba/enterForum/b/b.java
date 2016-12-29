package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean ayG;
    private i bpl;
    private int bpo;
    private int bpp;
    private int bpq;
    private String bpr;
    private d bps;
    private int isMem;
    private boolean vS;
    private int time = 0;
    private e bpj = new e();
    private i bpk = new i();
    private h bpm = new h();
    private c bpn = new c();

    public void cV(boolean z) {
        this.ayG = z;
    }

    public b() {
        this.vS = true;
        this.vS = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void gA(int i) {
        this.bpq = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void gB(int i) {
        this.bpo = i;
    }

    public void gC(int i) {
        this.bpp = i;
    }

    public void ia(String str) {
        this.bpr = str;
    }

    public void a(h hVar) {
        this.bpm = hVar;
    }

    public h SG() {
        return this.bpm;
    }

    public c SH() {
        return this.bpn;
    }

    public void a(c cVar) {
        this.bpn = cVar;
    }

    public d getHotSearchInfoData() {
        return this.bps;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                gB(dataRes.msign_valid.intValue());
                gC(dataRes.msign_level.intValue());
                gA(dataRes.is_login.intValue());
                ia(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bpj.setLevel(this.bpp);
                if (dataRes.like_forum != null) {
                    this.bpj.aa(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.bpk.aa(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bpm.Z(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bps = new d();
                    this.bps.a(dataRes.hot_search);
                }
                if (dataRes.frequently_forum_info != null) {
                    this.bpn.Z(dataRes.frequently_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i SI() {
        return this.bpk;
    }

    public void a(i iVar) {
        this.bpk = iVar;
    }

    public i SJ() {
        return this.bpl;
    }

    public void b(i iVar) {
        this.bpl = iVar;
    }

    public e SK() {
        return this.bpj;
    }

    public void a(e eVar) {
        this.bpj = eVar;
    }

    public void aB(boolean z) {
        this.vS = z;
    }

    public boolean isSuccess() {
        return this.vS;
    }

    public boolean SL() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.asw.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.asw.longValue();
    }

    public void a(d dVar) {
        this.bps = dVar;
    }
}
