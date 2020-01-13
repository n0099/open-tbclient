package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String cHN;
    public String glg;
    public String glh;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.glg = brandForumInfo.brand_desc;
            this.cHN = brandForumInfo.jump_url;
            this.glh = brandForumInfo.jump_desc;
        }
    }
}
