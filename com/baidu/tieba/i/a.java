package com.baidu.tieba.i;

import tbclient.GoodsWin;
/* loaded from: classes.dex */
public class a {
    public String goods_url;
    public Integer show;

    public void a(GoodsWin goodsWin) {
        this.show = goodsWin.show;
        this.goods_url = goodsWin.goods_url;
    }

    public boolean bMS() {
        return this.show.intValue() == 1;
    }
}
