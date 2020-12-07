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
    private View eOv;
    private ImageView fqN;
    private TextView kop;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.kop = null;
        this.fqN = null;
        this.eOv = null;
        initUI();
    }

    public View bYz() {
        return this.layoutView;
    }

    public void MV(String str) {
        this.kop.setText(str);
    }

    public void sk(boolean z) {
        this.fqN.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.kop = (TextView) this.layoutView.findViewById(R.id.text);
        this.fqN = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.eOv = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View cUp() {
        return this.eOv;
    }
}
