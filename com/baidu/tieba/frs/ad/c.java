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
    public static final BdUniqueId jmN = BdUniqueId.gen();
    private String eLu;
    private String eLv;
    public boolean jbD = false;
    private String jmO;
    private String jmP;
    private List<MediaData> jmQ;
    private int jmR;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.jmO = adInfo.portrait;
            this.eLu = adInfo.ad_name;
            this.jmP = adInfo.ad_desc;
            this.eLv = adInfo.ad_url;
            this.jmR = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.jmQ = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.jmQ.add(mediaData);
                }
            }
        }
    }

    public int cFg() {
        return this.jmR;
    }

    public String cFh() {
        return this.jmO;
    }

    public String cFi() {
        return this.eLu;
    }

    public String cFj() {
        return this.jmP;
    }

    public String bEY() {
        return this.eLv;
    }

    public List<MediaData> cFk() {
        return this.jmQ;
    }

    public void qT(boolean z) {
        this.jbD = z;
    }

    public boolean cFl() {
        return this.jbD;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jmN;
    }
}
