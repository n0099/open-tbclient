package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String cHB;
    public String ghW;
    public String ghX;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.ghW = brandForumInfo.brand_desc;
            this.cHB = brandForumInfo.jump_url;
            this.ghX = brandForumInfo.jump_desc;
        }
    }
}
