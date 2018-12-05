package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dMx = BdUniqueId.gen();
    private String apr;
    private String apt;
    public boolean dDL = false;
    private List<MediaData> dMA;
    private int dMB;
    private String dMy;
    private String dMz;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.dMy = adInfo.portrait;
            this.apr = adInfo.ad_name;
            this.dMz = adInfo.ad_desc;
            this.apt = adInfo.ad_url;
            this.dMB = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.dMA = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dMA.add(mediaData);
                }
            }
        }
    }

    public int aCH() {
        return this.dMB;
    }

    public String aCI() {
        return this.dMy;
    }

    public String aCJ() {
        return this.apr;
    }

    public String aCK() {
        return this.dMz;
    }

    public String PK() {
        return this.apt;
    }

    public List<MediaData> aCL() {
        return this.dMA;
    }

    public void gQ(boolean z) {
        this.dDL = z;
    }

    public boolean aCM() {
        return this.dDL;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dMx;
    }
}
