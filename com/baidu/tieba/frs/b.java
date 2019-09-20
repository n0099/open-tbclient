package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String bEl;
    public String fvc;
    public String fvd;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.fvc = brandForumInfo.brand_desc;
            this.bEl = brandForumInfo.jump_url;
            this.fvd = brandForumInfo.jump_desc;
        }
    }
}
