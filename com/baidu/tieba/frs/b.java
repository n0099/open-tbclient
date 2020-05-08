package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String arb;
    public String gXr;
    public String gXs;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.gXr = brandForumInfo.brand_desc;
            this.arb = brandForumInfo.jump_url;
            this.gXs = brandForumInfo.jump_desc;
        }
    }
}
