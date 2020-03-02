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
    private View cVT;
    private ImageView dto;
    private TextView hvO;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.hvO = null;
        this.dto = null;
        this.cVT = null;
        initUI();
    }

    public View bgF() {
        return this.layoutView;
    }

    public void CC(String str) {
        this.hvO.setText(str);
    }

    public void nm(boolean z) {
        this.dto.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.hvO = (TextView) this.layoutView.findViewById(R.id.text);
        this.dto = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.cVT = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View bSL() {
        return this.cVT;
    }
}
