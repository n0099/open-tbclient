package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String acH;
    public String dly;
    public String dlz;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.dly = brandForumInfo.brand_desc;
            this.acH = brandForumInfo.jump_url;
            this.dlz = brandForumInfo.jump_desc;
        }
    }
}
