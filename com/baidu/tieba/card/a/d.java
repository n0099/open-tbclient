package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b implements s {
    public static final BdUniqueId aVW = BdUniqueId.gen();
    public boolean aVX;
    public com.baidu.tbadk.core.data.b aVY;
    public String aeq;
    public int mPn;

    public d(com.baidu.tbadk.core.data.b bVar) {
        this.aeq = "";
        this.mPn = 0;
        this.aVY = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.aeq = "";
        this.mPn = 0;
        this.aVY = null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aVW;
    }

    @Override // com.baidu.tieba.card.a.s
    public int getPosition() {
        return com.baidu.adp.lib.h.b.g(this.aVY != null ? this.aVY.MM : "-1", -1);
    }

    @Override // com.baidu.tieba.card.a.s
    public boolean Ll() {
        return false;
    }

    @Override // com.baidu.tieba.card.a.s
    public void cn(boolean z) {
        this.aVX = z;
    }

    public String Lm() {
        if (this.aVY == null || this.aVY.MU == null) {
            return null;
        }
        return this.aVY.MU.userPortrait;
    }

    public String getUserName() {
        if (this.aVY == null || this.aVY.MU == null) {
            return null;
        }
        return this.aVY.MU.userName;
    }

    public String Ln() {
        if (this.aVY == null || this.aVY.MU == null) {
            return null;
        }
        return this.aVY.MU.Nc;
    }

    public String Lo() {
        if (this.aVY == null || this.aVY.MU == null) {
            return null;
        }
        return this.aVY.MU.FG;
    }

    public String Lp() {
        if (this.aVY == null || this.aVY.MU == null) {
            return null;
        }
        return this.aVY.MU.Ne;
    }

    public List<String> Lq() {
        if (this.aVY == null || this.aVY.MU == null) {
            return null;
        }
        return this.aVY.MU.Nj;
    }

    public com.baidu.tbadk.core.data.b Lr() {
        return this.aVY;
    }

    public boolean om() {
        if (this.aVY != null) {
            return this.aVY.om();
        }
        return false;
    }

    public boolean ol() {
        if (this.aVY != null) {
            return this.aVY.ol();
        }
        return false;
    }
}
