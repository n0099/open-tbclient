package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dnC = BdUniqueId.gen();
    private String aeb;
    private String aed;
    public boolean dfl = false;
    private String dnD;
    private String dnE;
    private List<MediaData> dnF;
    private int dnG;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.dnD = adInfo.portrait;
            this.aeb = adInfo.ad_name;
            this.dnE = adInfo.ad_desc;
            this.aed = adInfo.ad_url;
            this.dnG = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.dnF = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dnF.add(mediaData);
                }
            }
        }
    }

    public int avp() {
        return this.dnG;
    }

    public String avq() {
        return this.dnD;
    }

    public String avr() {
        return this.aeb;
    }

    public String avs() {
        return this.dnE;
    }

    public String Lh() {
        return this.aed;
    }

    public List<MediaData> avt() {
        return this.dnF;
    }

    public void fO(boolean z) {
        this.dfl = z;
    }

    public boolean avu() {
        return this.dfl;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dnC;
    }
}
