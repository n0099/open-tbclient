package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private ImageView ahZ;
    private View divider;
    private TextView eOW;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.eOW = null;
        this.ahZ = null;
        this.divider = null;
        initUI();
    }

    public View anZ() {
        return this.layoutView;
    }

    public void pW(String str) {
        this.eOW.setText(str);
    }

    public void ip(boolean z) {
        this.ahZ.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.address_lbs_item, (ViewGroup) null);
        this.eOW = (TextView) this.layoutView.findViewById(e.g.text);
        this.ahZ = (ImageView) this.layoutView.findViewById(e.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(e.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View aQb() {
        return this.divider;
    }
}
