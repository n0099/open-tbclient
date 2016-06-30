package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b implements s {
    public static final BdUniqueId aUY = BdUniqueId.gen();
    public String aIZ;
    public boolean aUZ;
    public com.baidu.tbadk.core.data.b aVa;
    public int mPn;

    public d(com.baidu.tbadk.core.data.b bVar) {
        this.aIZ = "";
        this.mPn = 0;
        this.aVa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.aIZ = "";
        this.mPn = 0;
        this.aVa = null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aUY;
    }

    @Override // com.baidu.tieba.card.a.s
    public int getPosition() {
        return com.baidu.adp.lib.h.b.g(this.aVa != null ? this.aVa.MO : "-1", -1);
    }

    @Override // com.baidu.tieba.card.a.s
    public boolean Lm() {
        return false;
    }

    @Override // com.baidu.tieba.card.a.s
    public void ck(boolean z) {
        this.aUZ = z;
    }

    public String Ln() {
        if (this.aVa == null || this.aVa.MW == null) {
            return null;
        }
        return this.aVa.MW.userPortrait;
    }

    public String getUserName() {
        if (this.aVa == null || this.aVa.MW == null) {
            return null;
        }
        return this.aVa.MW.userName;
    }

    public String Lo() {
        if (this.aVa == null || this.aVa.MW == null) {
            return null;
        }
        return this.aVa.MW.Ne;
    }

    public String Lp() {
        if (this.aVa == null || this.aVa.MW == null) {
            return null;
        }
        return this.aVa.MW.Fg;
    }

    public String Lq() {
        if (this.aVa == null || this.aVa.MW == null) {
            return null;
        }
        return this.aVa.MW.Ng;
    }

    public List<String> Lr() {
        if (this.aVa == null || this.aVa.MW == null) {
            return null;
        }
        return this.aVa.MW.Nl;
    }

    public com.baidu.tbadk.core.data.b Ls() {
        return this.aVa;
    }

    public boolean ox() {
        if (this.aVa != null) {
            return this.aVa.ox();
        }
        return false;
    }

    public boolean ow() {
        if (this.aVa != null) {
            return this.aVa.ow();
        }
        return false;
    }
}
