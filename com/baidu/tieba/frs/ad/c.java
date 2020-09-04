package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hZl = BdUniqueId.gen();
    private String dWk;
    private String dWl;
    public boolean hOb = false;
    private String hZm;
    private String hZn;
    private List<MediaData> hZo;
    private int hZp;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.hZm = adInfo.portrait;
            this.dWk = adInfo.ad_name;
            this.hZn = adInfo.ad_desc;
            this.dWl = adInfo.ad_url;
            this.hZp = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.hZo = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.hZo.add(mediaData);
                }
            }
        }
    }

    public int cow() {
        return this.hZp;
    }

    public String cox() {
        return this.hZm;
    }

    public String coy() {
        return this.dWk;
    }

    public String coz() {
        return this.hZn;
    }

    public String bvb() {
        return this.dWl;
    }

    public List<MediaData> coA() {
        return this.hZo;
    }

    public void oD(boolean z) {
        this.hOb = z;
    }

    public boolean coB() {
        return this.hOb;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hZl;
    }
}
