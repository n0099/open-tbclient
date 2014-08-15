package com.baidu.tieba.d.a;

import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class b {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;

    public b() {
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
    }

    public b(GoodsInfo goodsInfo) {
        if (goodsInfo == null) {
            this.a = 0;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = 0;
            return;
        }
        this.a = goodsInfo.id.intValue();
        this.b = goodsInfo.user_name;
        this.c = goodsInfo.user_portrait;
        this.d = goodsInfo.thread_title;
        this.e = goodsInfo.thread_pic;
        this.f = goodsInfo.pop_window_text;
        this.g = goodsInfo.goods_style.intValue();
    }
}
