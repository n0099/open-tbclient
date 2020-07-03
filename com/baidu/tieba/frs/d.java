package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String awR;
    public String hyE;
    public String hyF;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.hyE = brandForumInfo.brand_desc;
            this.awR = brandForumInfo.jump_url;
            this.hyF = brandForumInfo.jump_desc;
        }
    }
}
