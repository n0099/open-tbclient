package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class b {
    public String bDN;
    public String ftp;
    public String ftq;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.ftp = brandForumInfo.brand_desc;
            this.bDN = brandForumInfo.jump_url;
            this.ftq = brandForumInfo.jump_desc;
        }
    }
}
