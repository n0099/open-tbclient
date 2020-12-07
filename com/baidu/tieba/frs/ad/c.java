package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes22.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId iZj = BdUniqueId.gen();
    private String eEe;
    private String eEf;
    public boolean iOc = false;
    private String iZk;
    private String iZl;
    private List<MediaData> iZm;
    private int iZn;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.iZk = adInfo.portrait;
            this.eEe = adInfo.ad_name;
            this.iZl = adInfo.ad_desc;
            this.eEf = adInfo.ad_url;
            this.iZn = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.iZm = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.iZm.add(mediaData);
                }
            }
        }
    }

    public int cEI() {
        return this.iZn;
    }

    public String cEJ() {
        return this.iZk;
    }

    public String cEK() {
        return this.eEe;
    }

    public String cEL() {
        return this.iZl;
    }

    public String bGb() {
        return this.eEf;
    }

    public List<MediaData> cEM() {
        return this.iZm;
    }

    public void qp(boolean z) {
        this.iOc = z;
    }

    public boolean cEN() {
        return this.iOc;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iZj;
    }
}
