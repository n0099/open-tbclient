package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes7.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId grc = BdUniqueId.gen();
    private String cIT;
    private String cIU;
    private String grd;
    private String gre;
    private List<MediaData> grf;
    private int grg;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.grd = adInfo.portrait;
            this.cIT = adInfo.ad_name;
            this.gre = adInfo.ad_desc;
            this.cIU = adInfo.ad_url;
            this.grg = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.grf = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.grf.add(mediaData);
                }
            }
        }
    }

    public int bEs() {
        return this.grg;
    }

    public String bEt() {
        return this.grd;
    }

    public String bEu() {
        return this.cIT;
    }

    public String bEv() {
        return this.gre;
    }

    public String aPw() {
        return this.cIU;
    }

    public List<MediaData> bEw() {
        return this.grf;
    }

    public void lB(boolean z) {
        this.isLast = z;
    }

    public boolean bEx() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return grc;
    }
}
