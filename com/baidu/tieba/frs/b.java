package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String cLQ;
    public String gnh;
    public String gni;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.gnh = brandForumInfo.brand_desc;
            this.cLQ = brandForumInfo.jump_url;
            this.gni = brandForumInfo.jump_desc;
        }
    }
}
