package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aDi;
    public String hRM;
    public String hRN;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.hRM = brandForumInfo.brand_desc;
            this.aDi = brandForumInfo.jump_url;
            this.hRN = brandForumInfo.jump_desc;
        }
    }
}
