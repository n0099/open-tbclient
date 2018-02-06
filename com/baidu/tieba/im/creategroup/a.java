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
    private ImageView boQ;
    private View divider;
    private TextView ezv;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.ezv = null;
        this.boQ = null;
        this.divider = null;
        initUI();
    }

    public View aix() {
        return this.layoutView;
    }

    public void mT(String str) {
        this.ezv.setText(str);
    }

    public void hl(boolean z) {
        this.boQ.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.address_lbs_item, (ViewGroup) null);
        this.ezv = (TextView) this.layoutView.findViewById(d.g.text);
        this.boQ = (ImageView) this.layoutView.findViewById(d.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(d.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View aGx() {
        return this.divider;
    }
}
