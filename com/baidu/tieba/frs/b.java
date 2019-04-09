package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String bvM;
    public String eXJ;
    public String eXK;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.eXJ = brandForumInfo.brand_desc;
            this.bvM = brandForumInfo.jump_url;
            this.eXK = brandForumInfo.jump_desc;
        }
    }
}
