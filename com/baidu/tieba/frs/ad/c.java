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
    public static final BdUniqueId jly = BdUniqueId.gen();
    private String eNU;
    private String eNV;
    public boolean jap = false;
    private String jlA;
    private List<MediaData> jlB;
    private int jlC;
    private String jlz;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.jlz = adInfo.portrait;
            this.eNU = adInfo.ad_name;
            this.jlA = adInfo.ad_desc;
            this.eNV = adInfo.ad_url;
            this.jlC = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.jlB = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.jlB.add(mediaData);
                }
            }
        }
    }

    public int cHF() {
        return this.jlC;
    }

    public String cHG() {
        return this.jlz;
    }

    public String cHH() {
        return this.eNU;
    }

    public String cHI() {
        return this.jlA;
    }

    public String bIx() {
        return this.eNV;
    }

    public List<MediaData> cHJ() {
        return this.jlB;
    }

    public void qN(boolean z) {
        this.jap = z;
    }

    public boolean cHK() {
        return this.jap;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jly;
    }
}
