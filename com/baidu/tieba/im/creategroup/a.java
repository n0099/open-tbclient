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
    private TextView ekn;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.ekn = null;
        this.aIy = null;
        this.divider = null;
        initUI();
    }

    public View agG() {
        return this.layoutView;
    }

    public void nN(String str) {
        this.ekn.setText(str);
    }

    public void hh(boolean z) {
        this.aIy.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(d.i.address_lbs_item, (ViewGroup) null);
        this.ekn = (TextView) this.layoutView.findViewById(d.g.text);
        this.aIy = (ImageView) this.layoutView.findViewById(d.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(d.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View aGX() {
        return this.divider;
    }
}
