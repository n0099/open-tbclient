package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fyO = BdUniqueId.gen();
    private String bEU;
    private String bEV;
    private String fyP;
    private String fyQ;
    private List<MediaData> fyR;
    private int fyS;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.fyP = adInfo.portrait;
            this.bEU = adInfo.ad_name;
            this.fyQ = adInfo.ad_desc;
            this.bEV = adInfo.ad_url;
            this.fyS = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.fyR = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.fyR.add(mediaData);
                }
            }
        }
    }

    public int bnW() {
        return this.fyS;
    }

    public String bnX() {
        return this.fyP;
    }

    public String bnY() {
        return this.bEU;
    }

    public String bnZ() {
        return this.fyQ;
    }

    public String avZ() {
        return this.bEV;
    }

    public List<MediaData> boa() {
        return this.fyR;
    }

    public void ko(boolean z) {
        this.isLast = z;
    }

    public boolean bob() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fyO;
    }
}
