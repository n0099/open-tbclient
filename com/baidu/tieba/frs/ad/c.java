package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dEI = BdUniqueId.gen();
    private String alc;
    private String ale;
    private String dEJ;
    private String dEK;
    private List<MediaData> dEL;
    private int dEM;
    public boolean dvU = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.dEJ = adInfo.portrait;
            this.alc = adInfo.ad_name;
            this.dEK = adInfo.ad_desc;
            this.ale = adInfo.ad_url;
            this.dEM = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.dEL = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dEL.add(mediaData);
                }
            }
        }
    }

    public int aBz() {
        return this.dEM;
    }

    public String aBA() {
        return this.dEJ;
    }

    public String aBB() {
        return this.alc;
    }

    public String aBC() {
        return this.dEK;
    }

    public String Ov() {
        return this.ale;
    }

    public List<MediaData> aBD() {
        return this.dEL;
    }

    public void gF(boolean z) {
        this.dvU = z;
    }

    public boolean aBE() {
        return this.dvU;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dEI;
    }
}
