package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private View dJr;
    private ImageView ehX;
    private TextView iwP;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.iwP = null;
        this.ehX = null;
        this.dJr = null;
        initUI();
    }

    public View bvV() {
        return this.layoutView;
    }

    public void FX(String str) {
        this.iwP.setText(str);
    }

    public void oS(boolean z) {
        this.ehX.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.iwP = (TextView) this.layoutView.findViewById(R.id.text);
        this.ehX = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.dJr = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View ckk() {
        return this.dJr;
    }
}
