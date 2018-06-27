package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String adc;
    public String diK;
    public String diL;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.diK = brandForumInfo.brand_desc;
            this.adc = brandForumInfo.jump_url;
            this.diL = brandForumInfo.jump_desc;
        }
    }
}
