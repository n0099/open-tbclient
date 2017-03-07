package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b implements t {
    public String bqC;
    public AdvertAppInfo buX;
    public String mPageType;
    public int mPn;

    public d(AdvertAppInfo advertAppInfo) {
        this.bqC = "";
        this.mPn = 0;
        this.mPageType = "";
        this.buX = advertAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.bqC = "";
        this.mPn = 0;
        this.mPageType = "";
        this.buX = null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.buX != null && this.buX.legoCard != null) {
            return AdvertAppInfo.Tw;
        }
        if (this.buX != null && this.buX.getType() == AdvertAppInfo.Tk) {
            return AdvertAppInfo.Tt;
        }
        if (this.buX != null && this.buX.getType() == AdvertAppInfo.Tn) {
            return AdvertAppInfo.Tv;
        }
        return AdvertAppInfo.Tu;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.buX != null ? this.buX.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean SC() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cP(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.t
    public void cQ(boolean z) {
    }

    public String SD() {
        if (this.buX == null || this.buX.TJ == null) {
            return null;
        }
        return this.buX.TJ.userPortrait;
    }

    public String getUserName() {
        if (this.buX == null || this.buX.TJ == null) {
            return null;
        }
        return this.buX.TJ.userName;
    }

    public String SE() {
        if (this.buX == null || this.buX.TJ == null) {
            return null;
        }
        return this.buX.TJ.TS;
    }

    public String SF() {
        if (this.buX == null || this.buX.TJ == null) {
            return null;
        }
        return this.buX.TJ.TT;
    }

    public String SG() {
        if (this.buX == null || this.buX.TJ == null) {
            return null;
        }
        return this.buX.TJ.buttonText;
    }

    public String SH() {
        if (this.buX == null || this.buX.TJ == null) {
            return null;
        }
        return this.buX.TJ.TZ;
    }

    public String SI() {
        if (this.buX == null || this.buX.TJ == null) {
            return null;
        }
        return this.buX.TJ.TU;
    }

    public List<String> SJ() {
        if (this.buX == null || this.buX.TJ == null) {
            return null;
        }
        return this.buX.TJ.Ua;
    }

    public AdvertAppInfo SK() {
        return this.buX;
    }

    public boolean ps() {
        if (this.buX != null) {
            return this.buX.ps();
        }
        return false;
    }

    public boolean pr() {
        if (this.buX != null) {
            return this.buX.pr();
        }
        return false;
    }
}
