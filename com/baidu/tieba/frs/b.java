package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String cMd;
    public String gog;
    public String goh;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.gog = brandForumInfo.brand_desc;
            this.cMd = brandForumInfo.jump_url;
            this.goh = brandForumInfo.jump_desc;
        }
    }
}
