package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fBa = BdUniqueId.gen();
    private String bFt;
    private String bFu;
    private String fBb;
    private String fBc;
    private List<MediaData> fBd;
    private int fBe;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.fBb = adInfo.portrait;
            this.bFt = adInfo.ad_name;
            this.fBc = adInfo.ad_desc;
            this.bFu = adInfo.ad_url;
            this.fBe = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.fBd = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.fBd.add(mediaData);
                }
            }
        }
    }

    public int boR() {
        return this.fBe;
    }

    public String boS() {
        return this.fBb;
    }

    public String boT() {
        return this.bFt;
    }

    public String boU() {
        return this.fBc;
    }

    public String awn() {
        return this.bFu;
    }

    public List<MediaData> boV() {
        return this.fBd;
    }

    public void kr(boolean z) {
        this.isLast = z;
    }

    public boolean boW() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fBa;
    }
}
