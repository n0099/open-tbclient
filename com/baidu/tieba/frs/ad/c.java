package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hFc = BdUniqueId.gen();
    private String dGM;
    private String dGN;
    private String hFd;
    private String hFe;
    private List<MediaData> hFf;
    private int hFg;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.hFd = adInfo.portrait;
            this.dGM = adInfo.ad_name;
            this.hFe = adInfo.ad_desc;
            this.dGN = adInfo.ad_url;
            this.hFg = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.hFf = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.hFf.add(mediaData);
                }
            }
        }
    }

    public int cat() {
        return this.hFg;
    }

    public String cau() {
        return this.hFd;
    }

    public String cav() {
        return this.dGM;
    }

    public String caw() {
        return this.hFe;
    }

    public String biA() {
        return this.dGN;
    }

    public List<MediaData> cax() {
        return this.hFf;
    }

    public void ns(boolean z) {
        this.isLast = z;
    }

    public boolean cay() {
        return this.isLast;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hFc;
    }
}
