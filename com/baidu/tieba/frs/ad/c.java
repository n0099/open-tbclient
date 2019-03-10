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

    public int beD() {
        return this.fdV;
    }

    public String beE() {
        return this.fdS;
    }

    public String beF() {
        return this.bwC;
    }

    public String beG() {
        return this.fdT;
    }

    public String apQ() {
        return this.bwD;
    }

    public List<MediaData> beH() {
        return this.fdU;
    }

    public void ju(boolean z) {
        this.isLast = z;
    }

    public boolean beI() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fdR;
    }
}
