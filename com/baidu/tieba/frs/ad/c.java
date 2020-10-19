package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ivm = BdUniqueId.gen();
    private String ekw;
    private String ekx;
    public boolean ika = false;
    private String ivn;
    private String ivo;
    private List<MediaData> ivp;
    private int ivq;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.ivn = adInfo.portrait;
            this.ekw = adInfo.ad_name;
            this.ivo = adInfo.ad_desc;
            this.ekx = adInfo.ad_url;
            this.ivq = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.ivp = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.ivp.add(mediaData);
                }
            }
        }
    }

    public int cvh() {
        return this.ivq;
    }

    public String cvi() {
        return this.ivn;
    }

    public String cvj() {
        return this.ekw;
    }

    public String cvk() {
        return this.ivo;
    }

    public String byP() {
        return this.ekx;
    }

    public List<MediaData> cvl() {
        return this.ivp;
    }

    public void po(boolean z) {
        this.ika = z;
    }

    public boolean cvm() {
        return this.ika;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ivm;
    }
}
