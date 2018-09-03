package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dqt = BdUniqueId.gen();
    private String adF;
    private String adH;
    public boolean dhZ = false;
    private String dqu;
    private String dqv;
    private List<MediaData> dqw;
    private int dqx;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.dqu = adInfo.portrait;
            this.adF = adInfo.ad_name;
            this.dqv = adInfo.ad_desc;
            this.adH = adInfo.ad_url;
            this.dqx = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.dqw = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dqw.add(mediaData);
                }
            }
        }
    }

    public int avT() {
        return this.dqx;
    }

    public String avU() {
        return this.dqu;
    }

    public String avV() {
        return this.adF;
    }

    public String avW() {
        return this.dqv;
    }

    public String Lg() {
        return this.adH;
    }

    public List<MediaData> avX() {
        return this.dqw;
    }

    public void fQ(boolean z) {
        this.dhZ = z;
    }

    public boolean avY() {
        return this.dhZ;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dqt;
    }
}
