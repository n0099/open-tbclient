package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.v;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class b {
    private int aCp;
    private int aCq;
    private int aCr;
    private String aCs;
    private int aCt;
    private boolean abe;
    private boolean all;
    private int time = 0;
    private c aCm = new c();
    private v aCn = new v();
    private e aCo = new e();

    public void bw(boolean z) {
        this.all = z;
    }

    public b() {
        this.abe = true;
        this.abe = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void er(int i) {
        this.aCr = i;
    }

    public void setIsMem(int i) {
        this.aCt = i;
    }

    public int Go() {
        return this.aCp;
    }

    public void es(int i) {
        this.aCp = i;
    }

    public int Gp() {
        return this.aCq;
    }

    public void et(int i) {
        this.aCq = i;
    }

    public String Gq() {
        return this.aCs;
    }

    public void fn(String str) {
        this.aCs = str;
    }

    public void a(e eVar) {
        this.aCo = eVar;
    }

    public e Gr() {
        return this.aCo;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                es(dataRes.msign_valid.intValue());
                et(dataRes.msign_level.intValue());
                er(dataRes.is_login.intValue());
                fn(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.aCm.setLevel(this.aCq);
                if (dataRes.like_forum != null) {
                    this.aCm.i(dataRes.like_forum);
                }
                if (dataRes.banner != null) {
                    this.aCn.i(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.aCo.F(dataRes.recommend_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public v Gs() {
        return this.aCn;
    }

    public void a(v vVar) {
        this.aCn = vVar;
    }

    public c Gt() {
        return this.aCm;
    }

    public void a(c cVar) {
        this.aCm = cVar;
    }

    public void af(boolean z) {
        this.abe = z;
    }

    public boolean isSuccess() {
        return this.abe;
    }

    public boolean Gu() {
        return System.currentTimeMillis() / com.baidu.tbadk.data.b.agI.longValue() == (((long) this.time) * 1000) / com.baidu.tbadk.data.b.agI.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.abe) {
            if (this.aCm == null || this.aCm.Gw() == null || this.aCm.Gw().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }

    public boolean Gv() {
        if (this.aCm != null) {
            return this.aCm.Gv();
        }
        return false;
    }
}
