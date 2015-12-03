package com.baidu.tieba.homepage.listview.card.i;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.fragment.data.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.HomePage.HotVideo;
import tbclient.HomePage.HotVideoItem;
/* loaded from: classes.dex */
public class b implements u, e {
    public static final BdUniqueId bBN = BdUniqueId.gen();
    public long mid = 0;
    public String title = null;
    public String byY = null;
    public String byZ = null;
    public List<a> bBO = null;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bBN;
    }

    public void a(HotVideo hotVideo) {
        if (hotVideo != null) {
            this.mid = hotVideo.mid.longValue();
            this.title = hotVideo.title;
            this.byY = hotVideo.more_text;
            this.byZ = hotVideo.more_link;
            if (hotVideo.items != null) {
                this.bBO = new ArrayList();
                for (HotVideoItem hotVideoItem : hotVideo.items) {
                    if (hotVideoItem != null) {
                        a aVar = new a();
                        aVar.a(hotVideoItem);
                        this.bBO.add(aVar);
                    }
                }
            }
        }
    }

    public boolean TN() {
        return y.k(this.bBO) == 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        public long bAE = 0;
        public String title = null;
        public String bBy = null;
        public String bBP = null;
        public String videoUrl = null;
        public String videoMd5 = null;

        public void a(HotVideoItem hotVideoItem) {
            if (hotVideoItem != null) {
                this.bAE = hotVideoItem.tid.longValue();
                this.title = hotVideoItem.title;
                this.bBy = hotVideoItem._abstract;
                this.bBP = hotVideoItem.thumbnail_url;
                this.videoUrl = hotVideoItem.video_url;
                this.videoMd5 = hotVideoItem.video_md5;
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
