package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dFY = BdUniqueId.gen();
    private String alQ;
    private String alS;
    private String dFZ;
    private String dGa;
    private List<MediaData> dGb;
    private int dGc;
    public boolean dxm = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.dFZ = adInfo.portrait;
            this.alQ = adInfo.ad_name;
            this.dGa = adInfo.ad_desc;
            this.alS = adInfo.ad_url;
            this.dGc = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.dGb = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dGb.add(mediaData);
                }
            }
        }
    }

    public int aAX() {
        return this.dGc;
    }

    public String aAY() {
        return this.dFZ;
    }

    public String aAZ() {
        return this.alQ;
    }

    public String aBa() {
        return this.dGa;
    }

    public String OE() {
        return this.alS;
    }

    public List<MediaData> aBb() {
        return this.dGb;
    }

    public void gP(boolean z) {
        this.dxm = z;
    }

    public boolean aBc() {
        return this.dxm;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dFY;
    }
}
