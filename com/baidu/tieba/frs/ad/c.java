package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fdD = BdUniqueId.gen();
    private String bwI;
    private String bwJ;
    private String fdE;
    private String fdF;
    private List<MediaData> fdG;
    private int fdH;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.fdE = adInfo.portrait;
            this.bwI = adInfo.ad_name;
            this.fdF = adInfo.ad_desc;
            this.bwJ = adInfo.ad_url;
            this.fdH = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.fdG = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.fdG.add(mediaData);
                }
            }
        }
    }

    public int beA() {
        return this.fdH;
    }

    public String beB() {
        return this.fdE;
    }

    public String beC() {
        return this.bwI;
    }

    public String beD() {
        return this.fdF;
    }

    public String apM() {
        return this.bwJ;
    }

    public List<MediaData> beE() {
        return this.fdG;
    }

    public void ju(boolean z) {
        this.isLast = z;
    }

    public boolean beF() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fdD;
    }
}
