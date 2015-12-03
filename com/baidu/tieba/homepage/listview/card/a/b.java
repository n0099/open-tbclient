package com.baidu.tieba.homepage.listview.card.a;

import tbclient.PicTextItem;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.core.view.viewpager.a.a {
    public String byT = null;
    public PicTextItem byU = null;

    public void a(PicTextItem picTextItem) {
        this.byT = picTextItem.item_pic;
        this.byU = picTextItem;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a.a
    public String getImageUrl() {
        return this.byT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.viewpager.a.a
    /* renamed from: Ua */
    public PicTextItem wy() {
        return this.byU;
    }
}
