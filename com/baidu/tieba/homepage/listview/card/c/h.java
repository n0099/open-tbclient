package com.baidu.tieba.homepage.listview.card.c;

import tbclient.PicTextItem;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.core.view.viewpager.a.a {
    private PicTextItem bAe;
    private String url;

    public void b(PicTextItem picTextItem) {
        this.url = picTextItem.item_pic;
        this.bAe = picTextItem;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a.a
    public String getImageUrl() {
        return this.url;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a.a
    public Object wy() {
        return this.bAe;
    }
}
