package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private ImageView agE;
    private View divider;
    private TextView geZ;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.geZ = null;
        this.agE = null;
        this.divider = null;
        initUI();
    }

    public View aOM() {
        return this.layoutView;
    }

    public void wA(String str) {
        this.geZ.setText(str);
    }

    public void kP(boolean z) {
        this.agE.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.address_lbs_item, (ViewGroup) null);
        this.geZ = (TextView) this.layoutView.findViewById(d.g.text);
        this.agE = (ImageView) this.layoutView.findViewById(d.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(d.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View bqG() {
        return this.divider;
    }
}
