package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iNF = BdUniqueId.gen();
    private String eyP;
    private String eyQ;
    public boolean iCv = false;
    private String iNG;
    private String iNH;
    private List<MediaData> iNI;
    private int iNJ;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.iNG = adInfo.portrait;
            this.eyP = adInfo.ad_name;
            this.iNH = adInfo.ad_desc;
            this.eyQ = adInfo.ad_url;
            this.iNJ = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.iNI = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.iNI.add(mediaData);
                }
            }
        }
    }

    public int cAP() {
        return this.iNJ;
    }

    public String cAQ() {
        return this.iNG;
    }

    public String cAR() {
        return this.eyP;
    }

    public String cAS() {
        return this.iNH;
    }

    public String bDh() {
        return this.eyQ;
    }

    public List<MediaData> cAT() {
        return this.iNI;
    }

    public void pP(boolean z) {
        this.iCv = z;
    }

    public boolean cAU() {
        return this.iCv;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iNF;
    }
}
