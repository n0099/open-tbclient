package com.baidu.tieba.im.creategroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class a extends com.baidu.adp.a.f {
    private View a;
    private TextView c;
    private ImageView d;

    public a(Context context) {
        super(context);
        this.a = null;
        this.c = null;
        this.d = null;
        this.a = LayoutInflater.from(this.b).inflate(com.baidu.tieba.im.i.address_lbs_item, (ViewGroup) null);
        this.c = (TextView) this.a.findViewById(com.baidu.tieba.im.h.text);
        this.d = (ImageView) this.a.findViewById(com.baidu.tieba.im.h.group_address_list_item_selected);
        this.a.setTag(this);
    }

    public final View a() {
        return this.a;
    }

    public final void a(String str) {
        this.c.setText(str);
    }

    public final void a(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
    }
}
