package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b implements t {
    public String bqv;
    public AdvertAppInfo buP;
    public int buQ;
    public String mPageType;

    public d(AdvertAppInfo advertAppInfo) {
        this.bqv = "";
        this.buQ = 0;
        this.mPageType = "";
        this.buP = advertAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.bqv = "";
        this.buQ = 0;
        this.mPageType = "";
        this.buP = null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.buP != null && this.buP.legoCard != null) {
            return AdvertAppInfo.TP;
        }
        if (this.buP != null && this.buP.getType() == AdvertAppInfo.TC) {
            return AdvertAppInfo.TL;
        }
        if (this.buP != null && this.buP.getType() == AdvertAppInfo.TF) {
            return AdvertAppInfo.TO;
        }
        return AdvertAppInfo.TM;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.buP != null ? this.buP.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean Ta() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cR(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.t
    public void cS(boolean z) {
    }

    public String Tb() {
        if (this.buP == null || this.buP.Uc == null) {
            return null;
        }
        return this.buP.Uc.userPortrait;
    }

    public String getUserName() {
        if (this.buP == null || this.buP.Uc == null) {
            return null;
        }
        return this.buP.Uc.userName;
    }

    public String Tc() {
        if (this.buP == null || this.buP.Uc == null) {
            return null;
        }
        return this.buP.Uc.Uk;
    }

    public String Td() {
        if (this.buP == null || this.buP.Uc == null) {
            return null;
        }
        return this.buP.Uc.Ul;
    }

    public String Te() {
        if (this.buP == null || this.buP.Uc == null) {
            return null;
        }
        return this.buP.Uc.buttonText;
    }

    public String Tf() {
        if (this.buP == null || this.buP.Uc == null) {
            return null;
        }
        return this.buP.Uc.Ur;
    }

    public String Tg() {
        if (this.buP == null || this.buP.Uc == null) {
            return null;
        }
        return this.buP.Uc.Um;
    }

    public List<String> Th() {
        if (this.buP == null || this.buP.Uc == null) {
            return null;
        }
        return this.buP.Uc.Us;
    }

    public AdvertAppInfo Ti() {
        return this.buP;
    }

    public boolean pQ() {
        if (this.buP != null) {
            return this.buP.pQ();
        }
        return false;
    }

    public boolean pP() {
        if (this.buP != null) {
            return this.buP.pP();
        }
        return false;
    }
}
