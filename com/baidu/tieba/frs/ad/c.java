package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gtd = BdUniqueId.gen();
    private String cMW;
    private String cMX;
    private String gte;
    private String gtf;
    private List<MediaData> gtg;
    private int gth;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.gte = adInfo.portrait;
            this.cMW = adInfo.ad_name;
            this.gtf = adInfo.ad_desc;
            this.cMX = adInfo.ad_url;
            this.gth = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.gtg = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.gtg.add(mediaData);
                }
            }
        }
    }

    public int bFU() {
        return this.gth;
    }

    public String bFV() {
        return this.gte;
    }

    public String bFW() {
        return this.cMW;
    }

    public String bFX() {
        return this.gtf;
    }

    public String aRN() {
        return this.cMX;
    }

    public List<MediaData> bFY() {
        return this.gtg;
    }

    public void lE(boolean z) {
        this.isLast = z;
    }

    public boolean bFZ() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gtd;
    }
}
