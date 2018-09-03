package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private ImageView aIv;
    private View divider;
    private TextView eob;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.eob = null;
        this.aIv = null;
        this.divider = null;
        initUI();
    }

    public View ahd() {
        return this.layoutView;
    }

    public void nR(String str) {
        this.eob.setText(str);
    }

    public void hk(boolean z) {
        this.aIv.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(f.h.address_lbs_item, (ViewGroup) null);
        this.eob = (TextView) this.layoutView.findViewById(f.g.text);
        this.aIv = (ImageView) this.layoutView.findViewById(f.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(f.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View aHU() {
        return this.divider;
    }
}
