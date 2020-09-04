package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private ImageView eHE;
    private View egd;
    private TextView jke;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.jke = null;
        this.eHE = null;
        this.egd = null;
        initUI();
    }

    public View bLA() {
        return this.layoutView;
    }

    public void Kg(String str) {
        this.jke.setText(str);
    }

    public void qq(boolean z) {
        this.eHE.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.jke = (TextView) this.layoutView.findViewById(R.id.text);
        this.eHE = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.egd = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View cCy() {
        return this.egd;
    }
}
