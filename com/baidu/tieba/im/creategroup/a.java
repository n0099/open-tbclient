package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private ImageView boG;
    private View divider;
    private TextView ezz;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.ezz = null;
        this.boG = null;
        this.divider = null;
        initUI();
    }

    public View aix() {
        return this.layoutView;
    }

    public void mT(String str) {
        this.ezz.setText(str);
    }

    public void hq(boolean z) {
        this.boG.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.address_lbs_item, (ViewGroup) null);
        this.ezz = (TextView) this.layoutView.findViewById(d.g.text);
        this.boG = (ImageView) this.layoutView.findViewById(d.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(d.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View aGx() {
        return this.divider;
    }
}
