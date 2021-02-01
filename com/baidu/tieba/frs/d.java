package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aHq;
    public String jfa;
    public String jfb;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.jfa = brandForumInfo.brand_desc;
            this.aHq = brandForumInfo.jump_url;
            this.jfb = brandForumInfo.jump_desc;
        }
    }
}
