package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private ImageView aIy;
    private View divider;
    private TextView eog;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.eog = null;
        this.aIy = null;
        this.divider = null;
        initUI();
    }

    public View ahb() {
        return this.layoutView;
    }

    public void nP(String str) {
        this.eog.setText(str);
    }

    public void hk(boolean z) {
        this.aIy.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.address_lbs_item, (ViewGroup) null);
        this.eog = (TextView) this.layoutView.findViewById(d.g.text);
        this.aIy = (ImageView) this.layoutView.findViewById(d.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(d.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View aHX() {
        return this.divider;
    }
}
