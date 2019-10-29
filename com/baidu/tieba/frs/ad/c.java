package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fAo = BdUniqueId.gen();
    private String bXl;
    private String bXm;
    private String fAp;
    private String fAq;
    private List<MediaData> fAr;
    private int fAs;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.fAp = adInfo.portrait;
            this.bXl = adInfo.ad_name;
            this.fAq = adInfo.ad_desc;
            this.bXm = adInfo.ad_url;
            this.fAs = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.fAr = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.fAr.add(mediaData);
                }
            }
        }
    }

    public int blV() {
        return this.fAs;
    }

    public String blW() {
        return this.fAp;
    }

    public String blX() {
        return this.bXl;
    }

    public String blY() {
        return this.fAq;
    }

    public String axs() {
        return this.bXm;
    }

    public List<MediaData> blZ() {
        return this.fAr;
    }

    public void ke(boolean z) {
        this.isLast = z;
    }

    public boolean bma() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fAo;
    }
}
