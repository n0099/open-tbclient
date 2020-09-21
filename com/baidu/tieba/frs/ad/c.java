package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId igp = BdUniqueId.gen();
    private String dYu;
    private String dYv;
    public boolean hVb = false;
    private String igq;
    private String igr;
    private List<MediaData> igs;
    private int igt;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.igq = adInfo.portrait;
            this.dYu = adInfo.ad_name;
            this.igr = adInfo.ad_desc;
            this.dYv = adInfo.ad_url;
            this.igt = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.igs = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.igs.add(mediaData);
                }
            }
        }
    }

    public int crJ() {
        return this.igt;
    }

    public String crK() {
        return this.igq;
    }

    public String crL() {
        return this.dYu;
    }

    public String crM() {
        return this.igr;
    }

    public String bwf() {
        return this.dYv;
    }

    public List<MediaData> crN() {
        return this.igs;
    }

    public void oJ(boolean z) {
        this.hVb = z;
    }

    public boolean crO() {
        return this.hVb;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return igp;
    }
}
