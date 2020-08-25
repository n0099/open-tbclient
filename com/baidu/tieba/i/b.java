package com.baidu.tieba.i;

import tbclient.GoodsWin;
/* loaded from: classes2.dex */
public class b {
    public String goods_url;
    public Integer show;

    public void a(GoodsWin goodsWin) {
        this.show = goodsWin.show;
        this.goods_url = goodsWin.goods_url;
    }

    public boolean cvE() {
        return this.show.intValue() == 1;
    }
}
