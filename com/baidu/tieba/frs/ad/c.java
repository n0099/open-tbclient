package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fzn = BdUniqueId.gen();
    private String bEV;
    private String bEW;
    private String fzo;
    private String fzp;
    private List<MediaData> fzq;
    private int fzr;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.fzo = adInfo.portrait;
            this.bEV = adInfo.ad_name;
            this.fzp = adInfo.ad_desc;
            this.bEW = adInfo.ad_url;
            this.fzr = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.fzq = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.fzq.add(mediaData);
                }
            }
        }
    }

    public int bog() {
        return this.fzr;
    }

    public String boh() {
        return this.fzo;
    }

    public String boi() {
        return this.bEV;
    }

    public String boj() {
        return this.fzp;
    }

    public String awb() {
        return this.bEW;
    }

    public List<MediaData> bok() {
        return this.fzq;
    }

    public void ko(boolean z) {
        this.isLast = z;
    }

    public boolean bol() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fzn;
    }
}
