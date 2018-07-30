package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String acG;
    public String dlA;
    public String dlB;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.dlA = brandForumInfo.brand_desc;
            this.acG = brandForumInfo.jump_url;
            this.dlB = brandForumInfo.jump_desc;
        }
    }
}
