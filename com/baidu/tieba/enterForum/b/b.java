package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private boolean CB;
    private boolean aDn;
    private int bGl;
    private int bGm;
    private String bGn;
    private f bGo;
    private int isLogin;
    private int isMem;
    private int time = 0;
    private h bGj = new h();
    private k bGk = new k();

    public void dq(boolean z) {
        this.aDn = z;
    }

    public b() {
        this.CB = true;
        this.CB = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void hn(int i) {
        this.isLogin = i;
    }

    public void setIsMem(int i) {
        this.isMem = i;
    }

    public void ho(int i) {
        this.bGl = i;
    }

    public void hp(int i) {
        this.bGm = i;
    }

    public void it(String str) {
        this.bGn = str;
    }

    public f getHotSearchInfoData() {
        return this.bGo;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                ho(dataRes.msign_valid.intValue());
                hp(dataRes.msign_level.intValue());
                hn(dataRes.is_login.intValue());
                it(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.bGj.setLevel(this.bGm);
                if (dataRes.like_forum != null) {
                    this.bGj.ad(dataRes.like_forum);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.bGk.ae(dataRes.recommend_forum_info);
                }
                if (dataRes.hot_search != null) {
                    this.bGo = new f();
                    this.bGo.a(dataRes.hot_search);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h VT() {
        return this.bGj;
    }

    public void a(h hVar) {
        this.bGj = hVar;
    }

    public void a(k kVar) {
        this.bGk = kVar;
    }

    public k VU() {
        return this.bGk;
    }

    public void az(boolean z) {
        this.CB = z;
    }

    public boolean isSuccess() {
        return this.CB;
    }

    public boolean VV() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.d.axt.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.d.axt.longValue();
    }

    public void a(f fVar) {
        this.bGo = fVar;
    }
}
