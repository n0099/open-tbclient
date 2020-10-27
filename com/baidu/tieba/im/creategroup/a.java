package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private View eCZ;
    private ImageView feo;
    private TextView jUe;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.jUe = null;
        this.feo = null;
        this.eCZ = null;
        initUI();
    }

    public View bSY() {
        return this.layoutView;
    }

    public void LV(String str) {
        this.jUe.setText(str);
    }

    public void rw(boolean z) {
        this.feo.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.jUe = (TextView) this.layoutView.findViewById(R.id.text);
        this.feo = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.eCZ = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View cMU() {
        return this.eCZ;
    }
}
