package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b implements s {
    public String aPG;
    public com.baidu.tbadk.core.data.b bbS;
    public String mPageType;
    public int mPn;

    public d(com.baidu.tbadk.core.data.b bVar) {
        this.aPG = "";
        this.mPn = 0;
        this.mPageType = "";
        this.bbS = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.aPG = "";
        this.mPn = 0;
        this.mPageType = "";
        this.bbS = null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.bbS != null && this.bbS.Pp != null) {
            return com.baidu.tbadk.core.data.b.OX;
        }
        if (this.bbS != null && this.bbS.getType() == com.baidu.tbadk.core.data.b.OR) {
            return com.baidu.tbadk.core.data.b.OW;
        }
        return com.baidu.tbadk.core.data.b.OV;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return com.baidu.adp.lib.h.b.g(this.bbS != null ? this.bbS.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean Op() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.s
    public void ct(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.s
    public void cu(boolean z) {
    }

    public String Oq() {
        if (this.bbS == null || this.bbS.Pn == null) {
            return null;
        }
        return this.bbS.Pn.userPortrait;
    }

    public String getUserName() {
        if (this.bbS == null || this.bbS.Pn == null) {
            return null;
        }
        return this.bbS.Pn.userName;
    }

    public String Or() {
        if (this.bbS == null || this.bbS.Pn == null) {
            return null;
        }
        return this.bbS.Pn.Pr;
    }

    public String Os() {
        if (this.bbS == null || this.bbS.Pn == null) {
            return null;
        }
        return this.bbS.Pn.Ps;
    }

    public String Ot() {
        if (this.bbS == null || this.bbS.Pn == null) {
            return null;
        }
        return this.bbS.Pn.buttonText;
    }

    public String Ou() {
        if (this.bbS == null || this.bbS.Pn == null) {
            return null;
        }
        return this.bbS.Pn.Py;
    }

    public String Ov() {
        if (this.bbS == null || this.bbS.Pn == null) {
            return null;
        }
        return this.bbS.Pn.Pt;
    }

    public List<String> Ow() {
        if (this.bbS == null || this.bbS.Pn == null) {
            return null;
        }
        return this.bbS.Pn.Pz;
    }

    public com.baidu.tbadk.core.data.b Ox() {
        return this.bbS;
    }

    public boolean pj() {
        if (this.bbS != null) {
            return this.bbS.pj();
        }
        return false;
    }

    public boolean pi() {
        if (this.bbS != null) {
            return this.bbS.pi();
        }
        return false;
    }
}
