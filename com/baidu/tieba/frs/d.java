package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aIQ;
    public String jgX;
    public String jgY;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.jgX = brandForumInfo.brand_desc;
            this.aIQ = brandForumInfo.jump_url;
            this.jgY = brandForumInfo.jump_desc;
        }
    }
}
