package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String cLR;
    public String gnj;
    public String gnk;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.gnj = brandForumInfo.brand_desc;
            this.cLR = brandForumInfo.jump_url;
            this.gnk = brandForumInfo.jump_desc;
        }
    }
}
