package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hdn = BdUniqueId.gen();
    private String dmt;
    private String dmu;
    private String hdo;
    private String hdp;
    private List<MediaData> hdq;
    private int hdr;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.hdo = adInfo.portrait;
            this.dmt = adInfo.ad_name;
            this.hdp = adInfo.ad_desc;
            this.dmu = adInfo.ad_url;
            this.hdr = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.hdq = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.hdq.add(mediaData);
                }
            }
        }
    }

    public int bQI() {
        return this.hdr;
    }

    public String bQJ() {
        return this.hdo;
    }

    public String bQK() {
        return this.dmt;
    }

    public String bQL() {
        return this.hdp;
    }

    public String bab() {
        return this.dmu;
    }

    public List<MediaData> bQM() {
        return this.hdq;
    }

    public void mM(boolean z) {
        this.isLast = z;
    }

    public boolean bQN() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hdn;
    }
}
