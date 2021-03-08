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
    public static final BdUniqueId jow = BdUniqueId.gen();
    private String eMV;
    private String eMW;
    public boolean jdm = false;
    private int joA;
    private String jox;
    private String joy;
    private List<MediaData> joz;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.jox = adInfo.portrait;
            this.eMV = adInfo.ad_name;
            this.joy = adInfo.ad_desc;
            this.eMW = adInfo.ad_url;
            this.joA = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.joz = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.joz.add(mediaData);
                }
            }
        }
    }

    public int cFm() {
        return this.joA;
    }

    public String cFn() {
        return this.jox;
    }

    public String cFo() {
        return this.eMV;
    }

    public String cFp() {
        return this.joy;
    }

    public String bFc() {
        return this.eMW;
    }

    public List<MediaData> cFq() {
        return this.joz;
    }

    public void qT(boolean z) {
        this.jdm = z;
    }

    public boolean cFr() {
        return this.jdm;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jow;
    }
}
