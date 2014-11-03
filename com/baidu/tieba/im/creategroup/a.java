package com.baidu.tieba.im.creategroup;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    private ImageView Pl;
    private View aTa;
    private TextView aTb;

    public a(Context context) {
        super(context);
        this.aTa = null;
        this.aTb = null;
        this.Pl = null;
        initUI();
    }

    public View KS() {
        return this.aTa;
    }

    public void fL(String str) {
        this.aTb.setText(str);
    }

    public void cO(boolean z) {
        this.Pl.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.aTa = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.address_lbs_item, null);
        this.aTb = (TextView) this.aTa.findViewById(com.baidu.tieba.v.text);
        this.Pl = (ImageView) this.aTa.findViewById(com.baidu.tieba.v.group_address_list_item_selected);
        this.aTa.setTag(this);
    }
}
