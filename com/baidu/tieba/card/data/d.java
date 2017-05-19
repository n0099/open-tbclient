package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String btj;
    public AdvertAppInfo bxf;
    public int bxg;
    public String mPageType;

    public d(AdvertAppInfo advertAppInfo) {
        this.btj = "";
        this.bxg = 0;
        this.mPageType = "";
        this.bxf = advertAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.btj = "";
        this.bxg = 0;
        this.mPageType = "";
        this.bxf = null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.bxf != null && this.bxf.legoCard != null) {
            return AdvertAppInfo.Tj;
        }
        if (this.bxf != null && this.bxf.getType() == AdvertAppInfo.SX) {
            return AdvertAppInfo.Tg;
        }
        if (this.bxf != null && this.bxf.getType() == AdvertAppInfo.Ta) {
            return AdvertAppInfo.Ti;
        }
        return AdvertAppInfo.Th;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bxf != null ? this.bxf.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Tv() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dd(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void de(boolean z) {
    }

    public String Tw() {
        if (this.bxf == null || this.bxf.Tw == null) {
            return null;
        }
        return this.bxf.Tw.userPortrait;
    }

    public String getUserName() {
        if (this.bxf == null || this.bxf.Tw == null) {
            return null;
        }
        return this.bxf.Tw.userName;
    }

    public String Tx() {
        if (this.bxf == null || this.bxf.Tw == null) {
            return null;
        }
        return this.bxf.Tw.TE;
    }

    public String Ty() {
        if (this.bxf == null || this.bxf.Tw == null) {
            return null;
        }
        return this.bxf.Tw.TF;
    }

    public String Tz() {
        if (this.bxf == null || this.bxf.Tw == null) {
            return null;
        }
        return this.bxf.Tw.buttonText;
    }

    public String TA() {
        if (this.bxf == null || this.bxf.Tw == null) {
            return null;
        }
        return this.bxf.Tw.TL;
    }

    public String TB() {
        if (this.bxf == null || this.bxf.Tw == null) {
            return null;
        }
        return this.bxf.Tw.TG;
    }

    public List<String> TC() {
        if (this.bxf == null || this.bxf.Tw == null) {
            return null;
        }
        return this.bxf.Tw.TM;
    }

    public AdvertAppInfo TD() {
        return this.bxf;
    }

    public boolean px() {
        if (this.bxf != null) {
            return this.bxf.px();
        }
        return false;
    }

    public boolean pw() {
        if (this.bxf != null) {
            return this.bxf.pw();
        }
        return false;
    }
}
