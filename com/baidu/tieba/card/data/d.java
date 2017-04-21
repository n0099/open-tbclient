package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b implements t {
    public String bsM;
    public AdvertAppInfo bxg;
    public int bxh;
    public String mPageType;

    public d(AdvertAppInfo advertAppInfo) {
        this.bsM = "";
        this.bxh = 0;
        this.mPageType = "";
        this.bxg = advertAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.bsM = "";
        this.bxh = 0;
        this.mPageType = "";
        this.bxg = null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.bxg != null && this.bxg.legoCard != null) {
            return AdvertAppInfo.TR;
        }
        if (this.bxg != null && this.bxg.getType() == AdvertAppInfo.TE) {
            return AdvertAppInfo.TO;
        }
        if (this.bxg != null && this.bxg.getType() == AdvertAppInfo.TH) {
            return AdvertAppInfo.TQ;
        }
        return AdvertAppInfo.TP;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bxg != null ? this.bxg.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean Uc() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.t
    public void db(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.t
    public void dc(boolean z) {
    }

    public String Ud() {
        if (this.bxg == null || this.bxg.Ue == null) {
            return null;
        }
        return this.bxg.Ue.userPortrait;
    }

    public String getUserName() {
        if (this.bxg == null || this.bxg.Ue == null) {
            return null;
        }
        return this.bxg.Ue.userName;
    }

    public String Ue() {
        if (this.bxg == null || this.bxg.Ue == null) {
            return null;
        }
        return this.bxg.Ue.Um;
    }

    public String Uf() {
        if (this.bxg == null || this.bxg.Ue == null) {
            return null;
        }
        return this.bxg.Ue.Un;
    }

    public String Ug() {
        if (this.bxg == null || this.bxg.Ue == null) {
            return null;
        }
        return this.bxg.Ue.buttonText;
    }

    public String Uh() {
        if (this.bxg == null || this.bxg.Ue == null) {
            return null;
        }
        return this.bxg.Ue.Ut;
    }

    public String Ui() {
        if (this.bxg == null || this.bxg.Ue == null) {
            return null;
        }
        return this.bxg.Ue.Uo;
    }

    public List<String> Uj() {
        if (this.bxg == null || this.bxg.Ue == null) {
            return null;
        }
        return this.bxg.Ue.Uu;
    }

    public AdvertAppInfo Uk() {
        return this.bxg;
    }

    public boolean pQ() {
        if (this.bxg != null) {
            return this.bxg.pQ();
        }
        return false;
    }

    public boolean pP() {
        if (this.bxg != null) {
            return this.bxg.pP();
        }
        return false;
    }
}
