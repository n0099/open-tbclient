package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String bvG;
    public String eXX;
    public String eXY;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.eXX = brandForumInfo.brand_desc;
            this.bvG = brandForumInfo.jump_url;
            this.eXY = brandForumInfo.jump_desc;
        }
    }
}
