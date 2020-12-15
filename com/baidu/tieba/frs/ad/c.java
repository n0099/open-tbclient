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
    public static final BdUniqueId iZl = BdUniqueId.gen();
    private String eEe;
    private String eEf;
    public boolean iOe = false;
    private String iZm;
    private String iZn;
    private List<MediaData> iZo;
    private int iZp;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.iZm = adInfo.portrait;
            this.eEe = adInfo.ad_name;
            this.iZn = adInfo.ad_desc;
            this.eEf = adInfo.ad_url;
            this.iZp = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.iZo = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.iZo.add(mediaData);
                }
            }
        }
    }

    public int cEJ() {
        return this.iZp;
    }

    public String cEK() {
        return this.iZm;
    }

    public String cEL() {
        return this.eEe;
    }

    public String cEM() {
        return this.iZn;
    }

    public String bGb() {
        return this.eEf;
    }

    public List<MediaData> cEN() {
        return this.iZo;
    }

    public void qp(boolean z) {
        this.iOe = z;
    }

    public boolean cEO() {
        return this.iOe;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iZl;
    }
}
