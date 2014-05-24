package com.baidu.tieba.im.creategroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.c {
    private View a;
    private TextView b;
    private ImageView c;

    public a(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        b();
    }

    public View a() {
        return this.a;
    }

    public void a(String str) {
        this.b.setText(str);
    }

    public void a(boolean z) {
        this.c.setVisibility(z ? 0 : 8);
    }

    private void b() {
        this.a = LayoutInflater.from(this.mContext).inflate(com.baidu.tieba.w.address_lbs_item, (ViewGroup) null);
        this.b = (TextView) this.a.findViewById(com.baidu.tieba.v.text);
        this.c = (ImageView) this.a.findViewById(com.baidu.tieba.v.group_address_list_item_selected);
        this.a.setTag(this);
    }
}
