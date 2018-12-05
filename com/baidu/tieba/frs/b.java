package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String aou;
    public String dHi;
    public String dHj;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.dHi = brandForumInfo.brand_desc;
            this.aou = brandForumInfo.jump_url;
            this.dHj = brandForumInfo.jump_desc;
        }
    }
}
