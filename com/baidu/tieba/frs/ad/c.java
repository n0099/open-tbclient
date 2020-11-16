package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes21.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId iOs = BdUniqueId.gen();
    private String exd;
    private String exe;
    public boolean iDk = false;
    private String iOt;
    private String iOu;
    private List<MediaData> iOv;
    private int iOw;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.iOt = adInfo.portrait;
            this.exd = adInfo.ad_name;
            this.iOu = adInfo.ad_desc;
            this.exe = adInfo.ad_url;
            this.iOw = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.iOv = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.iOv.add(mediaData);
                }
            }
        }
    }

    public int cAs() {
        return this.iOw;
    }

    public String cAt() {
        return this.iOt;
    }

    public String cAu() {
        return this.exd;
    }

    public String cAv() {
        return this.iOu;
    }

    public String bCA() {
        return this.exe;
    }

    public List<MediaData> cAw() {
        return this.iOv;
    }

    public void pS(boolean z) {
        this.iDk = z;
    }

    public boolean cAx() {
        return this.iDk;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iOs;
    }
}
