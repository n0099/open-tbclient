package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aHq;
    public String jfo;
    public String jfp;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.jfo = brandForumInfo.brand_desc;
            this.aHq = brandForumInfo.jump_url;
            this.jfp = brandForumInfo.jump_desc;
        }
    }
}
