package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String aoX;
    public String dKG;
    public String dKH;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.dKG = brandForumInfo.brand_desc;
            this.aoX = brandForumInfo.jump_url;
            this.dKH = brandForumInfo.jump_desc;
        }
    }
}
