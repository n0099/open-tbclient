package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gts = BdUniqueId.gen();
    private String cMY;
    private String cMZ;
    private String gtt;
    private String gtu;
    private List<MediaData> gtv;
    private int gtw;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.gtt = adInfo.portrait;
            this.cMY = adInfo.ad_name;
            this.gtu = adInfo.ad_desc;
            this.cMZ = adInfo.ad_url;
            this.gtw = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.gtv = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.gtv.add(mediaData);
                }
            }
        }
    }

    public int bFX() {
        return this.gtw;
    }

    public String bFY() {
        return this.gtt;
    }

    public String bFZ() {
        return this.cMY;
    }

    public String bGa() {
        return this.gtu;
    }

    public String aRQ() {
        return this.cMZ;
    }

    public List<MediaData> bGb() {
        return this.gtv;
    }

    public void lE(boolean z) {
        this.isLast = z;
    }

    public boolean bGc() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gts;
    }
}
