package com.baidu.tieba.homepage.mygod.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerInfo;
import tbclient.GodBanner;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cEA = BdUniqueId.gen();
    private List<com.baidu.tbadk.core.flow.a.a> cEB = new ArrayList();
    private String cEC;
    private String cED;

    public a(BannerInfo bannerInfo) {
        this.cEC = null;
        this.cED = null;
        if (bannerInfo != null && !y.t(bannerInfo.god_banner_list)) {
            this.cEC = bannerInfo.god_good_url;
            this.cED = bannerInfo.god_rank_url;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bannerInfo.god_banner_list.size() && i2 < 3) {
                    GodBanner godBanner = bannerInfo.god_banner_list.get(i2);
                    if (godBanner != null) {
                        this.cEB.add(new C0064a(godBanner.pic_url, godBanner.link_url));
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
        return cEA;
    }

    public String amq() {
        return this.cEC;
    }

    public String amr() {
        return this.cED;
    }

    public List<com.baidu.tbadk.core.flow.a.a> ams() {
        return this.cEB;
    }

    /* renamed from: com.baidu.tieba.homepage.mygod.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0064a implements com.baidu.tbadk.core.flow.a.a {
        private String linkUrl;
        private String picUrl;

        public C0064a(String str, String str2) {
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
