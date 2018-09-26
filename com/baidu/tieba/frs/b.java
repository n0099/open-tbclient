package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String afi;
    public String drr;
    public String drs;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.drr = brandForumInfo.brand_desc;
            this.afi = brandForumInfo.jump_url;
            this.drs = brandForumInfo.jump_desc;
        }
    }
}
