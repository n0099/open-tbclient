package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aye;
    public String hEs;
    public String hEt;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.hEs = brandForumInfo.brand_desc;
            this.aye = brandForumInfo.jump_url;
            this.hEt = brandForumInfo.jump_desc;
        }
    }
}
