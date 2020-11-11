package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aIk;
    public String iGg;
    public String iGh;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.iGg = brandForumInfo.brand_desc;
            this.aIk = brandForumInfo.jump_url;
            this.iGh = brandForumInfo.jump_desc;
        }
    }
}
