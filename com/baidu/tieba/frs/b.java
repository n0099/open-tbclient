package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String cLS;
    public String gnw;
    public String gnx;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.gnw = brandForumInfo.brand_desc;
            this.cLS = brandForumInfo.jump_url;
            this.gnx = brandForumInfo.jump_desc;
        }
    }
}
