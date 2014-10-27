package com.baidu.tieba.im.creategroup;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    private ImageView Ph;
    private View aSM;
    private TextView aSN;

    public a(Context context) {
        super(context);
        this.aSM = null;
        this.aSN = null;
        this.Ph = null;
        initUI();
    }

    public View KO() {
        return this.aSM;
    }

    public void fL(String str) {
        this.aSN.setText(str);
    }

    public void cO(boolean z) {
        this.Ph.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.aSM = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.address_lbs_item, null);
        this.aSN = (TextView) this.aSM.findViewById(com.baidu.tieba.v.text);
        this.Ph = (ImageView) this.aSM.findViewById(com.baidu.tieba.v.group_address_list_item_selected);
        this.aSM.setTag(this);
    }
}
