package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes2.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId jgR = BdUniqueId.gen();
    private String eJj;
    private String eJk;
    public boolean iVI = false;
    private String jgS;
    private String jgT;
    private List<MediaData> jgU;
    private int jgV;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.jgS = adInfo.portrait;
            this.eJj = adInfo.ad_name;
            this.jgT = adInfo.ad_desc;
            this.eJk = adInfo.ad_url;
            this.jgV = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.jgU = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.jgU.add(mediaData);
                }
            }
        }
    }

    public int cDN() {
        return this.jgV;
    }

    public String cDO() {
        return this.jgS;
    }

    public String cDP() {
        return this.eJj;
    }

    public String cDQ() {
        return this.jgT;
    }

    public String bEF() {
        return this.eJk;
    }

    public List<MediaData> cDR() {
        return this.jgU;
    }

    public void qJ(boolean z) {
        this.iVI = z;
    }

    public boolean cDS() {
        return this.iVI;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jgR;
    }
}
