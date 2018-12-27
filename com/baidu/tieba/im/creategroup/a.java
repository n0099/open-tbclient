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
    private ImageView ahQ;
    private View divider;
    private TextView eOj;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.eOj = null;
        this.ahQ = null;
        this.divider = null;
        initUI();
    }

    public View anC() {
        return this.layoutView;
    }

    public void pG(String str) {
        this.eOj.setText(str);
    }

    public void ip(boolean z) {
        this.ahQ.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.address_lbs_item, (ViewGroup) null);
        this.eOj = (TextView) this.layoutView.findViewById(e.g.text);
        this.ahQ = (ImageView) this.layoutView.findViewById(e.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(e.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View aPB() {
        return this.divider;
    }
}
