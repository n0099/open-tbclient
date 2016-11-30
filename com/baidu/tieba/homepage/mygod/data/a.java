package com.baidu.tieba.homepage.mygod.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerInfo;
import tbclient.GodBanner;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cJN = BdUniqueId.gen();
    private List<com.baidu.tbadk.core.flow.a.a> cJO = new ArrayList();
    private String cJP;
    private String cJQ;

    public a(BannerInfo bannerInfo) {
        this.cJP = null;
        this.cJQ = null;
        if (bannerInfo != null && !x.t(bannerInfo.god_banner_list)) {
            this.cJP = bannerInfo.god_good_url;
            this.cJQ = bannerInfo.god_rank_url;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bannerInfo.god_banner_list.size() && i2 < 3) {
                    GodBanner godBanner = bannerInfo.god_banner_list.get(i2);
                    if (godBanner != null) {
                        this.cJO.add(new C0063a(godBanner.pic_url, godBanner.link_url));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cJN;
    }

    public String aol() {
        return this.cJP;
    }

    public String aom() {
        return this.cJQ;
    }

    public List<com.baidu.tbadk.core.flow.a.a> aon() {
        return this.cJO;
    }

    /* renamed from: com.baidu.tieba.homepage.mygod.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0063a implements com.baidu.tbadk.core.flow.a.a {
        private String linkUrl;
        private String picUrl;

        public C0063a(String str, String str2) {
            this.picUrl = str;
            this.linkUrl = str2;
        }

        @Override // com.baidu.tbadk.core.flow.a.a
        public String getPicUrl() {
            return this.picUrl;
        }

        @Override // com.baidu.tbadk.core.flow.a.a
        public String getPicLinkUrl() {
            return this.linkUrl;
        }
    }
}
