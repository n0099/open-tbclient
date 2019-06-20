package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ftS = BdUniqueId.gen();
    private String bDU;
    private String bDV;
    private String ftT;
    private String ftU;
    private List<MediaData> ftV;
    private int ftW;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.ftT = adInfo.portrait;
            this.bDU = adInfo.ad_name;
            this.ftU = adInfo.ad_desc;
            this.bDV = adInfo.ad_url;
            this.ftW = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.ftV = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.ftV.add(mediaData);
                }
            }
        }
    }

    public int blV() {
        return this.ftW;
    }

    public String blW() {
        return this.ftT;
    }

    public String blX() {
        return this.bDU;
    }

    public String blY() {
        return this.ftU;
    }

    public String auQ() {
        return this.bDV;
    }

    public List<MediaData> blZ() {
        return this.ftV;
    }

    public void ke(boolean z) {
        this.isLast = z;
    }

    public boolean bma() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ftS;
    }
}
