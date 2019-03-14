package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String bvI;
    public String eXW;
    public String eXX;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.eXW = brandForumInfo.brand_desc;
            this.bvI = brandForumInfo.jump_url;
            this.eXX = brandForumInfo.jump_desc;
        }
    }
}
