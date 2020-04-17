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
    private ImageView dTJ;
    private View dvs;
    private TextView ihn;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.ihn = null;
        this.dTJ = null;
        this.dvs = null;
        initUI();
    }

    public View bqc() {
        return this.layoutView;
    }

    public void El(String str) {
        this.ihn.setText(str);
    }

    public void ow(boolean z) {
        this.dTJ.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.ihn = (TextView) this.layoutView.findViewById(R.id.text);
        this.dTJ = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.dvs = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View cdE() {
        return this.dvs;
    }
}
