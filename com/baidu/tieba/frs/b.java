package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String akf;
    public String dzs;
    public String dzt;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.dzs = brandForumInfo.brand_desc;
            this.akf = brandForumInfo.jump_url;
            this.dzt = brandForumInfo.jump_desc;
        }
    }
}
