package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hZf = BdUniqueId.gen();
    private String dWg;
    private String dWh;
    public boolean hNV = false;
    private String hZg;
    private String hZh;
    private List<MediaData> hZi;
    private int hZj;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.hZg = adInfo.portrait;
            this.dWg = adInfo.ad_name;
            this.hZh = adInfo.ad_desc;
            this.dWh = adInfo.ad_url;
            this.hZj = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.hZi = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.hZi.add(mediaData);
                }
            }
        }
    }

    public int cov() {
        return this.hZj;
    }

    public String cow() {
        return this.hZg;
    }

    public String cox() {
        return this.dWg;
    }

    public String coy() {
        return this.hZh;
    }

    public String bva() {
        return this.dWh;
    }

    public List<MediaData> coz() {
        return this.hZi;
    }

    public void oB(boolean z) {
        this.hNV = z;
    }

    public boolean coA() {
        return this.hNV;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hZf;
    }
}
