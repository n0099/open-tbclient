package com.baidu.tieba.faceshop.emotioncenter.data;

import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private List<com.baidu.tbadk.core.flow.a.a> iYi = new ArrayList();

    public c(List<EmotionCenterData.BannerData> list) {
        if (list != null && !y.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                EmotionCenterData.BannerData bannerData = list.get(i);
                if (bannerData != null) {
                    this.iYi.add(new a(null, bannerData.url, bannerData.action, null, null, 0));
                }
            }
        }
    }

    public List<com.baidu.tbadk.core.flow.a.a> czU() {
        return this.iYi;
    }

    /* loaded from: classes9.dex */
    public class a implements com.baidu.tbadk.core.flow.a.a {
        private String desc;
        private cb iYj;
        private int iYk;
        private String linkUrl;
        private String name;
        private String picUrl;

        public a(cb cbVar, String str, String str2, String str3, String str4, int i) {
            this.iYj = cbVar;
            this.picUrl = str;
            this.linkUrl = str2;
            this.name = str3;
            this.desc = str4;
            this.iYk = i;
        }

        @Override // com.baidu.tbadk.core.flow.a.a
        public String getPicUrl() {
            return this.picUrl;
        }

        @Override // com.baidu.tbadk.core.flow.a.a
        public String blL() {
            return this.linkUrl;
        }
    }
}
