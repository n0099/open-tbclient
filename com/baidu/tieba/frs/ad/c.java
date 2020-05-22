package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hsb = BdUniqueId.gen();
    private String dAv;
    private String dAw;
    private String hsc;
    private String hsd;
    private List<MediaData> hse;
    private int hsf;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.hsc = adInfo.portrait;
            this.dAv = adInfo.ad_name;
            this.hsd = adInfo.ad_desc;
            this.dAw = adInfo.ad_url;
            this.hsf = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.hse = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.hse.add(mediaData);
                }
            }
        }
    }

    public int bXf() {
        return this.hsf;
    }

    public String bXg() {
        return this.hsc;
    }

    public String bXh() {
        return this.dAv;
    }

    public String bXi() {
        return this.hsd;
    }

    public String bgl() {
        return this.dAw;
    }

    public List<MediaData> bXj() {
        return this.hse;
    }

    public void nh(boolean z) {
        this.isLast = z;
    }

    public boolean bXk() {
        return this.isLast;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hsb;
    }
}
