package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String aou;
    public String dJW;
    public String dJX;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.dJW = brandForumInfo.brand_desc;
            this.aou = brandForumInfo.jump_url;
            this.dJX = brandForumInfo.jump_desc;
        }
    }
}
