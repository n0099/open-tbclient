package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean avH;
    private i buQ;
    private int buT;
    private int buU;
    private int buV;
    private String buW;
    private d buX;
    private int isMem;
    private boolean tF;
    private int time = 0;
    private e buO = new e();
    private i buP = new i();
    private h buR = new h();
    private c buS = new c();

    public void cN(boolean z) {
        this.avH = z;
    }

    public b() {
        this.tF = true;
        this.tF = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void gJ(int i) {
        this.buV = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void gK(int i) {
        this.buT = i;
    }

    public void gL(int i) {
        this.buU = i;
    }

    public void iB(String str) {
        this.buW = str;
    }

    public void a(h hVar) {
        this.buR = hVar;
    }

    public h So() {
        return this.buR;
    }

    public c Sp() {
        return this.buS;
    }

    public void a(c cVar) {
        this.buS = cVar;
    }

    public d getHotSearchInfoData() {
        return this.buX;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                gK(dataRes.msign_valid.intValue());
                gL(dataRes.msign_level.intValue());
                gJ(dataRes.is_login.intValue());
                iB(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.buO.setLevel(this.buU);
                if (dataRes.like_forum != null) {
                    this.buO.af(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.buP.af(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.buR.ae(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.buX = new d();
                    this.buX.a(dataRes.hot_search);
                }
                if (dataRes.frequently_forum_info != null) {
                    this.buS.ae(dataRes.frequently_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i Sq() {
        return this.buP;
    }

    public void a(i iVar) {
        this.buP = iVar;
    }

    public i Sr() {
        return this.buQ;
    }

    public void b(i iVar) {
        this.buQ = iVar;
    }

    public e Ss() {
        return this.buO;
    }

    public void a(e eVar) {
        this.buO = eVar;
    }

    public void aw(boolean z) {
        this.tF = z;
    }

    public boolean isSuccess() {
        return this.tF;
    }

    public boolean St() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.aph.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.aph.longValue();
    }

    public void a(d dVar) {
        this.buX = dVar;
    }
}
