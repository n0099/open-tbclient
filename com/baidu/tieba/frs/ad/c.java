package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hLa = BdUniqueId.gen();
    private String dMX;
    private String dMY;
    private String hLb;
    private String hLc;
    private List<MediaData> hLd;
    private int hLe;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.hLb = adInfo.portrait;
            this.dMX = adInfo.ad_name;
            this.hLc = adInfo.ad_desc;
            this.dMY = adInfo.ad_url;
            this.hLe = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.hLd = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.hLd.add(mediaData);
                }
            }
        }
    }

    public int cdR() {
        return this.hLe;
    }

    public String cdS() {
        return this.hLb;
    }

    public String cdT() {
        return this.dMX;
    }

    public String cdU() {
        return this.hLc;
    }

    public String bmn() {
        return this.dMY;
    }

    public List<MediaData> cdV() {
        return this.hLd;
    }

    public void nX(boolean z) {
        this.isLast = z;
    }

    public boolean cdW() {
        return this.isLast;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hLa;
    }
}
