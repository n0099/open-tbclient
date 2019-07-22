package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String bDN;
    public String fsQ;
    public String fsR;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.fsQ = brandForumInfo.brand_desc;
            this.bDN = brandForumInfo.jump_url;
            this.fsR = brandForumInfo.jump_desc;
        }
    }
}
