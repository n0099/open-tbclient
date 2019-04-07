package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String bvL;
    public String eXI;
    public String eXJ;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.eXI = brandForumInfo.brand_desc;
            this.bvL = brandForumInfo.jump_url;
            this.eXJ = brandForumInfo.jump_desc;
        }
    }
}
