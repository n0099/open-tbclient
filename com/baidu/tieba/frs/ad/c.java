package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fzx = BdUniqueId.gen();
    private String bWu;
    private String bWv;
    private List<MediaData> fzA;
    private int fzB;
    private String fzy;
    private String fzz;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.fzy = adInfo.portrait;
            this.bWu = adInfo.ad_name;
            this.fzz = adInfo.ad_desc;
            this.bWv = adInfo.ad_url;
            this.fzB = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.fzA = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.fzA.add(mediaData);
                }
            }
        }
    }

    public int blT() {
        return this.fzB;
    }

    public String blU() {
        return this.fzy;
    }

    public String blV() {
        return this.bWu;
    }

    public String blW() {
        return this.fzz;
    }

    public String axq() {
        return this.bWv;
    }

    public List<MediaData> blX() {
        return this.fzA;
    }

    public void ke(boolean z) {
        this.isLast = z;
    }

    public boolean blY() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fzx;
    }
}
