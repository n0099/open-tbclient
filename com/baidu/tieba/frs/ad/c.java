package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dPl = BdUniqueId.gen();
    private String apr;
    private String apt;
    public boolean dGz = false;
    private String dPm;
    private String dPn;
    private List<MediaData> dPo;
    private int dPp;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.dPm = adInfo.portrait;
            this.apr = adInfo.ad_name;
            this.dPn = adInfo.ad_desc;
            this.apt = adInfo.ad_url;
            this.dPp = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.dPo = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dPo.add(mediaData);
                }
            }
        }
    }

    public int aDw() {
        return this.dPp;
    }

    public String aDx() {
        return this.dPm;
    }

    public String aDy() {
        return this.apr;
    }

    public String aDz() {
        return this.dPn;
    }

    public String PM() {
        return this.apt;
    }

    public List<MediaData> aDA() {
        return this.dPo;
    }

    public void gT(boolean z) {
        this.dGz = z;
    }

    public boolean aDB() {
        return this.dGz;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dPl;
    }
}
