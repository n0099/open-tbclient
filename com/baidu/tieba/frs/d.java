package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aHs;
    public String iAj;
    public String iAk;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.iAj = brandForumInfo.brand_desc;
            this.aHs = brandForumInfo.jump_url;
            this.iAk = brandForumInfo.jump_desc;
        }
    }
}
