package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private View cRQ;
    private ImageView dpf;
    private TextView htN;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.htN = null;
        this.dpf = null;
        this.cRQ = null;
        initUI();
    }

    public View bet() {
        return this.layoutView;
    }

    public void Cm(String str) {
        this.htN.setText(str);
    }

    public void nk(boolean z) {
        this.dpf.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.htN = (TextView) this.layoutView.findViewById(R.id.text);
        this.dpf = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.cRQ = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View bRi() {
        return this.cRQ;
    }
}
