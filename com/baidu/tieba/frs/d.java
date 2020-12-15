package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aJj;
    public String iRO;
    public String iRP;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.iRO = brandForumInfo.brand_desc;
            this.aJj = brandForumInfo.jump_url;
            this.iRP = brandForumInfo.jump_desc;
        }
    }
}
