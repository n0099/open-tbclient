package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gtf = BdUniqueId.gen();
    private String cMX;
    private String cMY;
    private String gtg;
    private String gth;
    private List<MediaData> gti;
    private int gtj;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.gtg = adInfo.portrait;
            this.cMX = adInfo.ad_name;
            this.gth = adInfo.ad_desc;
            this.cMY = adInfo.ad_url;
            this.gtj = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.gti = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.gti.add(mediaData);
                }
            }
        }
    }

    public int bFW() {
        return this.gtj;
    }

    public String bFX() {
        return this.gtg;
    }

    public String bFY() {
        return this.cMX;
    }

    public String bFZ() {
        return this.gth;
    }

    public String aRP() {
        return this.cMY;
    }

    public List<MediaData> bGa() {
        return this.gti;
    }

    public void lE(boolean z) {
        this.isLast = z;
    }

    public boolean bGb() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gtf;
    }
}
