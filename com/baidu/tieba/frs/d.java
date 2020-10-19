package com.baidu.tieba.frs;

import tbclient.FrsPage.BrandForumInfo;
/* loaded from: classes.dex */
public class d {
    public String aHf;
    public String inN;
    public String inO;

    public void a(BrandForumInfo brandForumInfo) {
        if (brandForumInfo != null) {
            this.inN = brandForumInfo.brand_desc;
            this.aHf = brandForumInfo.jump_url;
            this.inO = brandForumInfo.jump_desc;
        }
    }
}
