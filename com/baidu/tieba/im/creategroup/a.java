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
    private ImageView boD;
    private View divider;
    private TextView ezj;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.ezj = null;
        this.boD = null;
        this.divider = null;
        initUI();
    }

    public View aiw() {
        return this.layoutView;
    }

    public void mT(String str) {
        this.ezj.setText(str);
    }

    public void hl(boolean z) {
        this.boD.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.address_lbs_item, (ViewGroup) null);
        this.ezj = (TextView) this.layoutView.findViewById(d.g.text);
        this.boD = (ImageView) this.layoutView.findViewById(d.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(d.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View aGw() {
        return this.divider;
    }
}
