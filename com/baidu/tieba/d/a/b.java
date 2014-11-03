package com.baidu.tieba.d.a;

import com.baidu.adp.lib.a.b.a.a.i;
import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class b extends i {
    public final int bHB;
    public final int id;
    public final String pop_window_text;
    public final String thread_pic;
    public final String thread_title;
    public final String user_name;
    public final String user_portrait;

    public b() {
        this.id = 0;
        this.user_name = null;
        this.user_portrait = null;
        this.thread_title = null;
        this.thread_pic = null;
        this.pop_window_text = null;
        this.bHB = 0;
    }

    public b(GoodsInfo goodsInfo) {
        if (goodsInfo == null) {
            this.id = 0;
            this.user_name = null;
            this.user_portrait = null;
            this.thread_title = null;
            this.thread_pic = null;
            this.pop_window_text = null;
            this.bHB = 0;
            return;
        }
        this.id = goodsInfo.id.intValue();
        this.user_name = goodsInfo.user_name;
        this.user_portrait = goodsInfo.user_portrait;
        this.thread_title = goodsInfo.thread_title;
        this.thread_pic = goodsInfo.thread_pic;
        this.pop_window_text = goodsInfo.pop_window_text;
        this.bHB = goodsInfo.goods_style.intValue();
    }
}
