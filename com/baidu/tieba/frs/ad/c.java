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
    public static final BdUniqueId jmz = BdUniqueId.gen();
    private String eLv;
    private String eLw;
    public boolean jbp = false;
    private String jmA;
    private String jmB;
    private List<MediaData> jmC;
    private int jmD;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.jmA = adInfo.portrait;
            this.eLv = adInfo.ad_name;
            this.jmB = adInfo.ad_desc;
            this.eLw = adInfo.ad_url;
            this.jmD = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.jmC = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.jmC.add(mediaData);
                }
            }
        }
    }

    public int cEZ() {
        return this.jmD;
    }

    public String cFa() {
        return this.jmA;
    }

    public String cFb() {
        return this.eLv;
    }

    public String cFc() {
        return this.jmB;
    }

    public String bEY() {
        return this.eLw;
    }

    public List<MediaData> cFd() {
        return this.jmC;
    }

    public void qT(boolean z) {
        this.jbp = z;
    }

    public boolean cFe() {
        return this.jbp;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jmz;
    }
}
