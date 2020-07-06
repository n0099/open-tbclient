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
    private View dQh;
    private ImageView eqH;
    private TextView iNU;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.iNU = null;
        this.eqH = null;
        this.dQh = null;
        initUI();
    }

    public View byR() {
        return this.layoutView;
    }

    public void Gz(String str) {
        this.iNU.setText(str);
    }

    public void pc(boolean z) {
        this.eqH.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.iNU = (TextView) this.layoutView.findViewById(R.id.text);
        this.eqH = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.dQh = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View coa() {
        return this.dQh;
    }
}
