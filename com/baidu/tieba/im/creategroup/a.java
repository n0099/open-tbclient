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
    private View eHl;
    private ImageView fjp;
    private TextView kaL;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.kaL = null;
        this.fjp = null;
        this.eHl = null;
        initUI();
    }

    public View bUQ() {
        return this.layoutView;
    }

    public void LN(String str) {
        this.kaL.setText(str);
    }

    public void rI(boolean z) {
        this.fjp.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.kaL = (TextView) this.layoutView.findViewById(R.id.text);
        this.fjp = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.eHl = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View cPb() {
        return this.eHl;
    }
}
