package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gtW = BdUniqueId.gen();
    private String cNl;
    private String cNm;
    private String gtX;
    private String gtY;
    private List<MediaData> gtZ;
    private int gua;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.gtX = adInfo.portrait;
            this.cNl = adInfo.ad_name;
            this.gtY = adInfo.ad_desc;
            this.cNm = adInfo.ad_url;
            this.gua = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.gtZ = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.gtZ.add(mediaData);
                }
            }
        }
    }

    public int bGi() {
        return this.gua;
    }

    public String bGj() {
        return this.gtX;
    }

    public String bGk() {
        return this.cNl;
    }

    public String bGl() {
        return this.gtY;
    }

    public String aRU() {
        return this.cNm;
    }

    public List<MediaData> bGm() {
        return this.gtZ;
    }

    public void lJ(boolean z) {
        this.isLast = z;
    }

    public boolean bGn() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gtW;
    }
}
