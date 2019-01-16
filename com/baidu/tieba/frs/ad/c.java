package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dPU = BdUniqueId.gen();
    private String apT;
    private String apV;
    public boolean dHi = false;
    private String dPV;
    private String dPW;
    private List<MediaData> dPX;
    private int dPY;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.dPV = adInfo.portrait;
            this.apT = adInfo.ad_name;
            this.dPW = adInfo.ad_desc;
            this.apV = adInfo.ad_url;
            this.dPY = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.dPX = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dPX.add(mediaData);
                }
            }
        }
    }

    public int aDT() {
        return this.dPY;
    }

    public String aDU() {
        return this.dPV;
    }

    public String aDV() {
        return this.apT;
    }

    public String aDW() {
        return this.dPW;
    }

    public String Qe() {
        return this.apV;
    }

    public List<MediaData> aDX() {
        return this.dPX;
    }

    public void gW(boolean z) {
        this.dHi = z;
    }

    public boolean aDY() {
        return this.dHi;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dPU;
    }
}
