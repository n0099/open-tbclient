package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b implements s {
    public String aRe;
    public com.baidu.tbadk.core.data.c beh;
    public String mPageType;
    public int mPn;

    public d(com.baidu.tbadk.core.data.c cVar) {
        this.aRe = "";
        this.mPn = 0;
        this.mPageType = "";
        this.beh = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.aRe = "";
        this.mPn = 0;
        this.mPageType = "";
        this.beh = null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.beh != null && this.beh.Py != null) {
            return com.baidu.tbadk.core.data.c.Ph;
        }
        if (this.beh != null && this.beh.getType() == com.baidu.tbadk.core.data.c.OU) {
            return com.baidu.tbadk.core.data.c.Pe;
        }
        if (this.beh != null && this.beh.getType() == com.baidu.tbadk.core.data.c.OX) {
            return com.baidu.tbadk.core.data.c.Pg;
        }
        return com.baidu.tbadk.core.data.c.Pf;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return com.baidu.adp.lib.h.b.g(this.beh != null ? this.beh.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean OO() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cA(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.s
    public void cB(boolean z) {
    }

    public String OP() {
        if (this.beh == null || this.beh.Pw == null) {
            return null;
        }
        return this.beh.Pw.userPortrait;
    }

    public String getUserName() {
        if (this.beh == null || this.beh.Pw == null) {
            return null;
        }
        return this.beh.Pw.userName;
    }

    public String OQ() {
        if (this.beh == null || this.beh.Pw == null) {
            return null;
        }
        return this.beh.Pw.PH;
    }

    public String OR() {
        if (this.beh == null || this.beh.Pw == null) {
            return null;
        }
        return this.beh.Pw.PI;
    }

    public String OS() {
        if (this.beh == null || this.beh.Pw == null) {
            return null;
        }
        return this.beh.Pw.buttonText;
    }

    public String OT() {
        if (this.beh == null || this.beh.Pw == null) {
            return null;
        }
        return this.beh.Pw.PO;
    }

    public String OU() {
        if (this.beh == null || this.beh.Pw == null) {
            return null;
        }
        return this.beh.Pw.PJ;
    }

    public List<String> OV() {
        if (this.beh == null || this.beh.Pw == null) {
            return null;
        }
        return this.beh.Pw.PP;
    }

    public com.baidu.tbadk.core.data.c OW() {
        return this.beh;
    }

    public boolean pl() {
        if (this.beh != null) {
            return this.beh.pl();
        }
        return false;
    }

    public boolean pk() {
        if (this.beh != null) {
            return this.beh.pk();
        }
        return false;
    }
}
