package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String bCP;
    public String fnR;
    public String fnS;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.fnR = brandForumInfo.brand_desc;
            this.bCP = brandForumInfo.jump_url;
            this.fnS = brandForumInfo.jump_desc;
        }
    }
}
