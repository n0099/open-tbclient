package com.baidu.tieba.frs.ad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dwH = BdUniqueId.gen();
    private String agg;
    private String agi;
    public boolean dnR = false;
    private String dwI;
    private String dwJ;
    private List<MediaData> dwK;
    private int dwL;

    public void a(AdInfo adInfo) {
        if (adInfo != null) {
            this.dwI = adInfo.portrait;
            this.agg = adInfo.ad_name;
            this.dwJ = adInfo.ad_desc;
            this.agi = adInfo.ad_url;
            this.dwL = adInfo.show_rule.intValue();
            if (adInfo.media != null) {
                this.dwK = new ArrayList();
                for (Media media : adInfo.media) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dwK.add(mediaData);
                }
            }
        }
    }

    public int aye() {
        return this.dwL;
    }

    public String ayf() {
        return this.dwI;
    }

    public String ayg() {
        return this.agg;
    }

    public String ayh() {
        return this.dwJ;
    }

    public String Mx() {
        return this.agi;
    }

    public List<MediaData> ayi() {
        return this.dwK;
    }

    public void gn(boolean z) {
        this.dnR = z;
    }

    public boolean ayj() {
        return this.dnR;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dwH;
    }
}
