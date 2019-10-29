package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String bWc;
    public String fup;
    public String fuq;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.fup = brandForumInfo.brand_desc;
            this.bWc = brandForumInfo.jump_url;
            this.fuq = brandForumInfo.jump_desc;
        }
    }
}
