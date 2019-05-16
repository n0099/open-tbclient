package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String bCP;
    public String fnQ;
    public String fnR;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.fnQ = brandForumInfo.brand_desc;
            this.bCP = brandForumInfo.jump_url;
            this.fnR = brandForumInfo.jump_desc;
        }
    }
}
