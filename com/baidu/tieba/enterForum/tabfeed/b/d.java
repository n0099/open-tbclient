package com.baidu.tieba.enterForum.tabfeed.b;

import com.baidu.adp.BdUniqueId;
import tbclient.GeneralResource;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gHj = BdUniqueId.gen();
    public int gHk;
    public String res_image;
    public String res_link;

    public void a(GeneralResource generalResource) {
        if (generalResource != null) {
            this.res_image = generalResource.res_image;
            this.res_link = generalResource.res_link;
            this.gHk = generalResource.res_floor.intValue();
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gHj;
    }
}
