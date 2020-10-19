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
    private ImageView eVS;
    private View euA;
    private TextView jHF;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.jHF = null;
        this.eVS = null;
        this.euA = null;
        initUI();
    }

    public View bQb() {
        return this.layoutView;
    }

    public void Lx(String str) {
        this.jHF.setText(str);
    }

    public void re(boolean z) {
        this.eVS.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.jHF = (TextView) this.layoutView.findViewById(R.id.text);
        this.eVS = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.euA = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View cJN() {
        return this.euA;
    }
}
