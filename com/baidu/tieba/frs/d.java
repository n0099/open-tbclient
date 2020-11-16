package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aGz;
    public String iGU;
    public String iGV;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.iGU = brandForumInfo.brand_desc;
            this.aGz = brandForumInfo.jump_url;
            this.iGV = brandForumInfo.jump_desc;
        }
    }
}
