package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String aqV;
    public String gXl;
    public String gXm;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.gXl = brandForumInfo.brand_desc;
            this.aqV = brandForumInfo.jump_url;
            this.gXm = brandForumInfo.jump_desc;
        }
    }
}
