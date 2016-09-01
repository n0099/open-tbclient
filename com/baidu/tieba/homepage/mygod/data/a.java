package com.baidu.tieba.homepage.mygod.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerInfo;
import tbclient.GodBanner;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cDW = BdUniqueId.gen();
    private List<com.baidu.tbadk.core.flow.a.a> cDX = new ArrayList();
    private String cDY;
    private String cDZ;

    public a(BannerInfo bannerInfo) {
        this.cDY = null;
        this.cDZ = null;
        if (bannerInfo != null && !y.t(bannerInfo.god_banner_list)) {
            this.cDY = bannerInfo.god_good_url;
            this.cDZ = bannerInfo.god_rank_url;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bannerInfo.god_banner_list.size() && i2 < 3) {
                    GodBanner godBanner = bannerInfo.god_banner_list.get(i2);
                    if (godBanner != null) {
                        this.cDX.add(new C0061a(godBanner.pic_url, godBanner.link_url));
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
        return cDW;
    }

    public String amc() {
        return this.cDY;
    }

    public String amd() {
        return this.cDZ;
    }

    public List<com.baidu.tbadk.core.flow.a.a> ame() {
        return this.cDX;
    }

    /* renamed from: com.baidu.tieba.homepage.mygod.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0061a implements com.baidu.tbadk.core.flow.a.a {
        private String linkUrl;
        private String picUrl;

        public C0061a(String str, String str2) {
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
