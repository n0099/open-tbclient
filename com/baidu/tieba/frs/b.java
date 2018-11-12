package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String akS;
    public String dAJ;
    public String dAK;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.dAJ = brandForumInfo.brand_desc;
            this.akS = brandForumInfo.jump_url;
            this.dAK = brandForumInfo.jump_desc;
        }
    }
}
