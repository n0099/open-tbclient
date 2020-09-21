package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private ImageView eJL;
    private View eis;
    private TextView jsI;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.jsI = null;
        this.eJL = null;
        this.eis = null;
        initUI();
    }

    public View bMK() {
        return this.layoutView;
    }

    public void KI(String str) {
        this.jsI.setText(str);
    }

    public void qy(boolean z) {
        this.eJL.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.jsI = (TextView) this.layoutView.findViewById(R.id.text);
        this.eJL = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.eis = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View cGe() {
        return this.eis;
    }
}
