package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aJH;
    public String jea;
    public String jeb;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.jea = brandForumInfo.brand_desc;
            this.aJH = brandForumInfo.jump_url;
            this.jeb = brandForumInfo.jump_desc;
        }
    }
}
