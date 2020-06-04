package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hsm = BdUniqueId.gen();
    private String dAv;
    private String dAw;
    private String hsn;
    private String hso;
    private List<MediaData> hsp;
    private int hsq;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.hsn = adInfo.portrait;
            this.dAv = adInfo.ad_name;
            this.hso = adInfo.ad_desc;
            this.dAw = adInfo.ad_url;
            this.hsq = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.hsp = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.hsp.add(mediaData);
                }
            }
        }
    }

    public int bXh() {
        return this.hsq;
    }

    public String bXi() {
        return this.hsn;
    }

    public String bXj() {
        return this.dAv;
    }

    public String bXk() {
        return this.hso;
    }

    public String bgm() {
        return this.dAw;
    }

    public List<MediaData> bXl() {
        return this.hsp;
    }

    public void nh(boolean z) {
        this.isLast = z;
    }

    public boolean bXm() {
        return this.isLast;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hsm;
    }
}
