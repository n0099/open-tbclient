package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fdR = BdUniqueId.gen();
    private String bwC;
    private String bwD;
    private String fdS;
    private String fdT;
    private List<MediaData> fdU;
    private int fdV;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.fdS = adInfo.portrait;
            this.bwC = adInfo.ad_name;
            this.fdT = adInfo.ad_desc;
            this.bwD = adInfo.ad_url;
            this.fdV = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.fdU = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.fdU.add(mediaData);
                }
            }
        }
    }

    public int beC() {
        return this.fdV;
    }

    public String beD() {
        return this.fdS;
    }

    public String beE() {
        return this.bwC;
    }

    public String beF() {
        return this.fdT;
    }

    public String apP() {
        return this.bwD;
    }

    public List<MediaData> beG() {
        return this.fdU;
    }

    public void ju(boolean z) {
        this.isLast = z;
    }

    public boolean beH() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fdR;
    }
}
