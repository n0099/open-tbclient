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
    private View eIO;
    private ImageView fkh;
    private TextView kaa;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.kaa = null;
        this.fkh = null;
        this.eIO = null;
        initUI();
    }

    public View bVx() {
        return this.layoutView;
    }

    public void Mm(String str) {
        this.kaa.setText(str);
    }

    public void rF(boolean z) {
        this.fkh.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.kaa = (TextView) this.layoutView.findViewById(R.id.text);
        this.fkh = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.eIO = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View cPv() {
        return this.eIO;
    }
}
