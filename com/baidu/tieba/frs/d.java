package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aEb;
    public String hYM;
    public String hYN;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.hYM = brandForumInfo.brand_desc;
            this.aEb = brandForumInfo.jump_url;
            this.hYN = brandForumInfo.jump_desc;
        }
    }
}
