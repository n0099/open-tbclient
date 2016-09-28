package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean ayr;
    private i bGo;
    private int bGr;
    private int bGs;
    private int bGt;
    private String bGu;
    private d bGv;
    private int isMem;
    private boolean vS;
    private int time = 0;
    private e bGm = new e();
    private i bGn = new i();
    private h bGp = new h();
    private c bGq = new c();

    public void di(boolean z) {
        this.ayr = z;
    }

    public b() {
        this.vS = true;
        this.vS = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void hp(int i) {
        this.bGt = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void hq(int i) {
        this.bGr = i;
    }

    public void hr(int i) {
        this.bGs = i;
    }

    public void jr(String str) {
        this.bGu = str;
    }

    public void a(h hVar) {
        this.bGp = hVar;
    }

    public h Xt() {
        return this.bGp;
    }

    public c Xu() {
        return this.bGq;
    }

    public void a(c cVar) {
        this.bGq = cVar;
    }

    public d getHotSearchInfoData() {
        return this.bGv;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                hq(dataRes.msign_valid.intValue());
                hr(dataRes.msign_level.intValue());
                hp(dataRes.is_login.intValue());
                jr(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bGm.setLevel(this.bGs);
                if (dataRes.like_forum != null) {
                    this.bGm.ah(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.bGn.ah(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bGp.ag(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bGv = new d();
                    this.bGv.a(dataRes.hot_search);
                }
                if (dataRes.frequently_forum_info != null) {
                    this.bGq.ag(dataRes.frequently_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public i Xv() {
        return this.bGn;
    }

    public void a(i iVar) {
        this.bGn = iVar;
    }

    public i Xw() {
        return this.bGo;
    }

    public void b(i iVar) {
        this.bGo = iVar;
    }

    public e Xx() {
        return this.bGm;
    }

    public void a(e eVar) {
        this.bGm = eVar;
    }

    public void ax(boolean z) {
        this.vS = z;
    }

    public boolean isSuccess() {
        return this.vS;
    }

    public boolean Xy() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.arZ.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.arZ.longValue();
    }

    public void a(d dVar) {
        this.bGv = dVar;
    }
}
