package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ftR = BdUniqueId.gen();
    private String bDT;
    private String bDU;
    private String ftS;
    private String ftT;
    private List<MediaData> ftU;
    private int ftV;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.ftS = adInfo.portrait;
            this.bDT = adInfo.ad_name;
            this.ftT = adInfo.ad_desc;
            this.bDU = adInfo.ad_url;
            this.ftV = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.ftU = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.ftU.add(mediaData);
                }
            }
        }
    }

    public int blS() {
        return this.ftV;
    }

    public String blT() {
        return this.ftS;
    }

    public String blU() {
        return this.bDT;
    }

    public String blV() {
        return this.ftT;
    }

    public String auQ() {
        return this.bDU;
    }

    public List<MediaData> blW() {
        return this.ftU;
    }

    public void ke(boolean z) {
        this.isLast = z;
    }

    public boolean blX() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ftR;
    }
}
