package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes2.dex */
public class d {
    public String aDg;
    public String hRG;
    public String hRH;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.hRG = brandForumInfo.brand_desc;
            this.aDg = brandForumInfo.jump_url;
            this.hRH = brandForumInfo.jump_desc;
        }
    }
}
