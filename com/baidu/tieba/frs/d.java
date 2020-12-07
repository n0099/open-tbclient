package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aJj;
    public String iRM;
    public String iRN;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.iRM = brandForumInfo.brand_desc;
            this.aJj = brandForumInfo.jump_url;
            this.iRN = brandForumInfo.jump_desc;
        }
    }
}
