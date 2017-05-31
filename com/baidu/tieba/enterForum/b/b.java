package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean CB;
    private boolean aDa;
    private int bMa;
    private int bMb;
    private String bMc;
    private f bMd;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private h bLY = new h();
    private k bLZ = new k();

    public void dH(boolean z) {
        this.aDa = z;
    }

    public b() {
        this.CB = true;
        this.CB = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void hL(int i) {
        this.isLogin = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void hM(int i) {
        this.bMa = i;
    }

    public void hN(int i) {
        this.bMb = i;
    }

    public void iB(String str) {
        this.bMc = str;
    }

    public f getHotSearchInfoData() {
        return this.bMd;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                hM(dataRes.msign_valid.intValue());
                hN(dataRes.msign_level.intValue());
                hL(dataRes.is_login.intValue());
                iB(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bLY.setLevel(this.bMb);
                if (dataRes.like_forum != null) {
                    this.bLY.ad(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bLZ.ae(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bMd = new f();
                    this.bMd.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h WW() {
        return this.bLY;
    }

    public void a(h hVar) {
        this.bLY = hVar;
    }

    public void a(k kVar) {
        this.bLZ = kVar;
    }

    public k WX() {
        return this.bLZ;
    }

    public void ay(boolean z) {
        this.CB = z;
    }

    public boolean isSuccess() {
        return this.CB;
    }

    public boolean WY() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.e.axf.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.e.axf.longValue();
    }

    public void a(f fVar) {
        this.bMd = fVar;
    }
}
