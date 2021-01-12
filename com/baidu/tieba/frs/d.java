package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aEU;
    public String iZt;
    public String iZu;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.iZt = brandForumInfo.brand_desc;
            this.aEU = brandForumInfo.jump_url;
            this.iZu = brandForumInfo.jump_desc;
        }
    }
}
