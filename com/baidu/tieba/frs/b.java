package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String aoW;
    public String dKF;
    public String dKG;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.dKF = brandForumInfo.brand_desc;
            this.aoW = brandForumInfo.jump_url;
            this.dKG = brandForumInfo.jump_desc;
        }
    }
}
