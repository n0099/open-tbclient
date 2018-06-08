package com.baidu.tieba.frs.worldcup.talkball.b;

import tbclient.BannerImage;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String dFK;
    private String mImgUrl;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.mImgUrl = bannerImage.img_url;
            this.dFK = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String ub() {
        return this.mImgUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String tW() {
        return this.dFK;
    }
}
