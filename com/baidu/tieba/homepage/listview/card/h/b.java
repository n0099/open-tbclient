package com.baidu.tieba.homepage.listview.card.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.HomePage.BannerTwzbInfo;
import tbclient.HomePage.HotTwzbThread;
import tbclient.HomePage.TwzbThreadItem;
/* loaded from: classes.dex */
public class b implements u, com.baidu.tieba.homepage.fragment.data.e {
    public static final BdUniqueId bBv = BdUniqueId.gen();
    public long mid = 0;
    public String title = null;
    public String byY = null;
    public String byZ = null;
    public a bBw = null;
    public List<C0065b> bBx = null;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bBv;
    }

    public boolean TN() {
        return this.bBw == null || !TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_PHOTOLIVE_ACTIVITY);
    }

    public void a(HotTwzbThread hotTwzbThread) {
        int i;
        if (hotTwzbThread != null) {
            this.mid = hotTwzbThread.mid.longValue();
            this.title = hotTwzbThread.title;
            this.byY = hotTwzbThread.more_text;
            this.byZ = hotTwzbThread.more_link;
            if (hotTwzbThread.banner_twzb != null && !StringUtils.isNull(hotTwzbThread.banner_twzb.pic_url)) {
                this.bBw = new a();
                this.bBw.a(hotTwzbThread.banner_twzb);
            }
            if (hotTwzbThread.items != null) {
                this.bBx = new ArrayList();
                int size = hotTwzbThread.items.size();
                int i2 = size > 2 ? 2 : size;
                int i3 = 0;
                int i4 = 0;
                while (i3 < size) {
                    TwzbThreadItem twzbThreadItem = hotTwzbThread.items.get(i3);
                    if (twzbThreadItem == null || StringUtils.isNull(twzbThreadItem.pic_url) || StringUtils.isNull(twzbThreadItem.title)) {
                        i = i4;
                    } else {
                        C0065b c0065b = new C0065b();
                        c0065b.a(twzbThreadItem);
                        this.bBx.add(c0065b);
                        i = i4 + 1;
                    }
                    if (i == i2) {
                        break;
                    }
                    i3++;
                    i4 = i;
                }
            }
            C0065b c0065b2 = (C0065b) y.b(this.bBx, 0);
            if (c0065b2 != null) {
                c0065b2.bBz = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public long bAE = 0;
        public String title = null;
        public String picUrl = null;
        public String linkUrl = null;

        public void a(BannerTwzbInfo bannerTwzbInfo) {
            if (bannerTwzbInfo != null) {
                this.bAE = bannerTwzbInfo.tid.longValue();
                this.title = bannerTwzbInfo.title;
                this.picUrl = bannerTwzbInfo.pic_url;
                this.linkUrl = bannerTwzbInfo.link_url;
            }
        }
    }

    /* renamed from: com.baidu.tieba.homepage.listview.card.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0065b {
        public long bAE = 0;
        public String title = null;
        public String bBy = null;
        public String picUrl = null;
        public String linkUrl = null;
        public boolean bBz = false;

        public void a(TwzbThreadItem twzbThreadItem) {
            if (twzbThreadItem != null) {
                this.bAE = twzbThreadItem.tid.longValue();
                this.title = twzbThreadItem.title;
                this.bBy = twzbThreadItem._abstract;
                this.picUrl = twzbThreadItem.pic_url;
                this.linkUrl = twzbThreadItem.link_url;
            }
        }
    }

    @Override // com.baidu.tieba.homepage.fragment.data.e
    public long getMid() {
        return this.mid;
    }

    @Override // com.baidu.tieba.homepage.fragment.data.e
    public String getTitle() {
        return this.title;
    }

    @Override // com.baidu.tieba.homepage.fragment.data.e
    public String TR() {
        return this.byY;
    }

    @Override // com.baidu.tieba.homepage.fragment.data.e
    public String TS() {
        return this.byZ;
    }
}
