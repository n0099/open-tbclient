package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dqv = BdUniqueId.gen();
    private String adF;
    private String adH;
    public boolean dib = false;
    private String dqw;
    private String dqx;
    private List<MediaData> dqy;
    private int dqz;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.dqw = adInfo.portrait;
            this.adF = adInfo.ad_name;
            this.dqx = adInfo.ad_desc;
            this.adH = adInfo.ad_url;
            this.dqz = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.dqy = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dqy.add(mediaData);
                }
            }
        }
    }

    public int avU() {
        return this.dqz;
    }

    public String avV() {
        return this.dqw;
    }

    public String avW() {
        return this.adF;
    }

    public String avX() {
        return this.dqx;
    }

    public String Lc() {
        return this.adH;
    }

    public List<MediaData> avY() {
        return this.dqy;
    }

    public void fQ(boolean z) {
        this.dib = z;
    }

    public boolean avZ() {
        return this.dib;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dqv;
    }
}
