package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String bVl;
    public String fty;
    public String ftz;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.fty = brandForumInfo.brand_desc;
            this.bVl = brandForumInfo.jump_url;
            this.ftz = brandForumInfo.jump_desc;
        }
    }
}
