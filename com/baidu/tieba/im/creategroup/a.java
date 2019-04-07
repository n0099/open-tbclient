package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private ImageView agJ;
    private View divider;
    private TextView geN;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.geN = null;
        this.agJ = null;
        this.divider = null;
        initUI();
    }

    public View aOH() {
        return this.layoutView;
    }

    public void wz(String str) {
        this.geN.setText(str);
    }

    public void kP(boolean z) {
        this.agJ.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.address_lbs_item, (ViewGroup) null);
        this.geN = (TextView) this.layoutView.findViewById(d.g.text);
        this.agJ = (ImageView) this.layoutView.findViewById(d.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(d.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View bqD() {
        return this.divider;
    }
}
