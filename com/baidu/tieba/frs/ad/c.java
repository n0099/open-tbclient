package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fdQ = BdUniqueId.gen();
    private String bwE;
    private String bwF;
    private String fdR;
    private String fdS;
    private List<MediaData> fdT;
    private int fdU;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.fdR = adInfo.portrait;
            this.bwE = adInfo.ad_name;
            this.fdS = adInfo.ad_desc;
            this.bwF = adInfo.ad_url;
            this.fdU = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.fdT = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.fdT.add(mediaData);
                }
            }
        }
    }

    public int beC() {
        return this.fdU;
    }

    public String beD() {
        return this.fdR;
    }

    public String beE() {
        return this.bwE;
    }

    public String beF() {
        return this.fdS;
    }

    public String apP() {
        return this.bwF;
    }

    public List<MediaData> beG() {
        return this.fdT;
    }

    public void ju(boolean z) {
        this.isLast = z;
    }

    public boolean beH() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fdQ;
    }
}
