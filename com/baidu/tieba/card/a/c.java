package com.baidu.tieba.card.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.ae;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ai {
    private String aRL;
    private int aRM;
    private String aRN;
    private String aRO;
    private String mSource;

    public void setWeight(String str) {
        this.aRL = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void fB(int i) {
        this.aRM = i;
    }

    public void gS(String str) {
        this.aRN = str;
    }

    public int Ke() {
        return this.aRM;
    }

    public String Kf() {
        return String.valueOf(this.mSource) + ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR + this.aRM + ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR + this.aRN;
    }

    public String getWeight() {
        return this.aRL;
    }

    public String getSource() {
        return this.mSource;
    }

    public String Kg() {
        return this.aRN;
    }

    public String Kh() {
        return this.aRO;
    }

    public void gT(String str) {
        this.aRO = str;
    }

    public ah Ki() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public au gU(String str) {
        ah Ki = Ki();
        if (Ki == null) {
            return null;
        }
        return new au(str).aa(ImageViewerConfig.FORUM_ID, String.valueOf(Ki.getFid())).aa("tid", String.valueOf(Ki.getTid())).aa("obj_param1", getWeight()).aa("obj_source", getSource()).r("obj_locate", Ke()).aa("obj_param3", ae.JU()).r("obj_type", Kj());
    }

    private int Kj() {
        boolean z;
        ah Ki = Ki();
        if (Ki == null) {
            return 0;
        }
        boolean z2 = (StringUtils.isNull(Ki.tr()) && StringUtils.isNull(Ki.getTitle())) ? false : true;
        ArrayList<MediaData> medias = Ki.getMedias();
        if (medias != null) {
            Iterator<MediaData> it = medias.iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && (next.getType() == 3 || next.getType() == 5)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return z2 ? z ? 3 : 1 : z ? 2 : 0;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public ArrayList<com.baidu.tbadk.core.util.ah> getImages() {
        ah Ki = Ki();
        if (Ki != null) {
            return Ki.getImages();
        }
        return null;
    }
}
