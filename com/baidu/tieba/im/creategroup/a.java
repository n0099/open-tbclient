package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private ImageView aAU;
    private View cfh;
    private TextView gCf;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.gCf = null;
        this.aAU = null;
        this.cfh = null;
        initUI();
    }

    public View aMv() {
        return this.layoutView;
    }

    public void xt(String str) {
        this.gCf.setText(str);
    }

    public void lK(boolean z) {
        this.aAU.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.gCf = (TextView) this.layoutView.findViewById(R.id.text);
        this.aAU = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.cfh = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View byI() {
        return this.cfh;
    }
}
