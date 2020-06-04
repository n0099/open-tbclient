package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String auL;
    public String hmo;
    public String hmp;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.hmo = brandForumInfo.brand_desc;
            this.auL = brandForumInfo.jump_url;
            this.hmp = brandForumInfo.jump_desc;
        }
    }
}
