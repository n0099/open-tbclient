package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iHI = BdUniqueId.gen();
    private String esV;
    private String esW;
    private String iHJ;
    private String iHK;
    private List<MediaData> iHL;
    private int iHM;
    public boolean iwy = false;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.iHJ = adInfo.portrait;
            this.esV = adInfo.ad_name;
            this.iHK = adInfo.ad_desc;
            this.esW = adInfo.ad_url;
            this.iHM = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.iHL = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.iHL.add(mediaData);
                }
            }
        }
    }

    public int cyo() {
        return this.iHM;
    }

    public String cyp() {
        return this.iHJ;
    }

    public String cyq() {
        return this.esV;
    }

    public String cyr() {
        return this.iHK;
    }

    public String bAI() {
        return this.esW;
    }

    public List<MediaData> cys() {
        return this.iHL;
    }

    public void pG(boolean z) {
        this.iwy = z;
    }

    public boolean cyt() {
        return this.iwy;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iHI;
    }
}
