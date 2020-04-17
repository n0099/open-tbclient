package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hdh = BdUniqueId.gen();
    private String dmp;
    private String dmq;
    private String hdi;
    private String hdj;
    private List<MediaData> hdk;
    private int hdl;
    public boolean isLast = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.hdi = adInfo.portrait;
            this.dmp = adInfo.ad_name;
            this.hdj = adInfo.ad_desc;
            this.dmq = adInfo.ad_url;
            this.hdl = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.hdk = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.hdk.add(mediaData);
                }
            }
        }
    }

    public int bQK() {
        return this.hdl;
    }

    public String bQL() {
        return this.hdi;
    }

    public String bQM() {
        return this.dmp;
    }

    public String bQN() {
        return this.hdj;
    }

    public String bad() {
        return this.dmq;
    }

    public List<MediaData> bQO() {
        return this.hdk;
    }

    public void mM(boolean z) {
        this.isLast = z;
    }

    public boolean bQP() {
        return this.isLast;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hdh;
    }
}
