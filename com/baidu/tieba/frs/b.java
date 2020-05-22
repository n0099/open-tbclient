package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String auL;
    public String hmd;
    public String hme;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.hmd = brandForumInfo.brand_desc;
            this.auL = brandForumInfo.jump_url;
            this.hme = brandForumInfo.jump_desc;
        }
    }
}
