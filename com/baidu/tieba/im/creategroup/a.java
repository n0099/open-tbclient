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
    private View cWh;
    private ImageView dtO;
    private TextView hxA;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.hxA = null;
        this.dtO = null;
        this.cWh = null;
        initUI();
    }

    public View bgL() {
        return this.layoutView;
    }

    public void CC(String str) {
        this.hxA.setText(str);
    }

    public void ns(boolean z) {
        this.dtO.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.hxA = (TextView) this.layoutView.findViewById(R.id.text);
        this.dtO = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.cWh = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View bTe() {
        return this.cWh;
    }
}
