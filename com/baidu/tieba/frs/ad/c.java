package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dPV = BdUniqueId.gen();
    private String apU;
    private String apW;
    public boolean dHj = false;
    private String dPW;
    private String dPX;
    private List<MediaData> dPY;
    private int dPZ;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.dPW = adInfo.portrait;
            this.apU = adInfo.ad_name;
            this.dPX = adInfo.ad_desc;
            this.apW = adInfo.ad_url;
            this.dPZ = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.dPY = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dPY.add(mediaData);
                }
            }
        }
    }

    public int aDT() {
        return this.dPZ;
    }

    public String aDU() {
        return this.dPW;
    }

    public String aDV() {
        return this.apU;
    }

    public String aDW() {
        return this.dPX;
    }

    public String Qe() {
        return this.apW;
    }

    public List<MediaData> aDX() {
        return this.dPY;
    }

    public void gW(boolean z) {
        this.dHj = z;
    }

    public boolean aDY() {
        return this.dHj;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dPV;
    }
}
