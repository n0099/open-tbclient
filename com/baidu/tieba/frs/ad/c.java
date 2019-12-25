package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gnT = BdUniqueId.gen();
    private String cIH;
    private String cII;
    private String gnU;
    private String gnV;
    private List<MediaData> gnW;
    private int gnX;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.gnU = adInfo.portrait;
            this.cIH = adInfo.ad_name;
            this.gnV = adInfo.ad_desc;
            this.cII = adInfo.ad_url;
            this.gnX = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.gnW = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.gnW.add(mediaData);
                }
            }
        }
    }

    public int bDq() {
        return this.gnX;
    }

    public String bDr() {
        return this.gnU;
    }

    public String bDs() {
        return this.cIH;
    }

    public String bDt() {
        return this.gnV;
    }

    public String aPd() {
        return this.cII;
    }

    public List<MediaData> bDu() {
        return this.gnW;
    }

    public void lq(boolean z) {
        this.isLast = z;
    }

    public boolean bDv() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gnT;
    }
}
