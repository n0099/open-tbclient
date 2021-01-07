package com.baidu.tieba.faceshop.emotioncenter.data;

import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private List<com.baidu.tbadk.core.flow.a.a> iXi = new ArrayList();

    public c(List<EmotionCenterData.BannerData> list) {
        if (list != null && !x.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                EmotionCenterData.BannerData bannerData = list.get(i);
                if (bannerData != null) {
                    this.iXi.add(new a(null, bannerData.url, bannerData.action, null, null, 0));
                }
            }
        }
    }

    public List<com.baidu.tbadk.core.flow.a.a> cCB() {
        return this.iXi;
    }

    /* loaded from: classes9.dex */
    public class a implements com.baidu.tbadk.core.flow.a.a {
        private String desc;
        private bz iXj;
        private int iXk;
        private String linkUrl;
        private String name;
        private String picUrl;

        public a(bz bzVar, String str, String str2, String str3, String str4, int i) {
            this.iXj = bzVar;
            this.picUrl = str;
            this.linkUrl = str2;
            this.name = str3;
            this.desc = str4;
            this.iXk = i;
        }

        @Override // com.baidu.tbadk.core.flow.a.a
        public String getPicUrl() {
            return this.picUrl;
        }

        @Override // com.baidu.tbadk.core.flow.a.a
        public String bpn() {
            return this.linkUrl;
        }
    }
}
