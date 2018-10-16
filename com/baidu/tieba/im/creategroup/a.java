package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private ImageView aQn;
    private View divider;
    private TextView eDj;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.eDj = null;
        this.aQn = null;
        this.divider = null;
        initUI();
    }

    public View amt() {
        return this.layoutView;
    }

    public void pa(String str) {
        this.eDj.setText(str);
    }

    public void ia(boolean z) {
        this.aQn.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.address_lbs_item, (ViewGroup) null);
        this.eDj = (TextView) this.layoutView.findViewById(e.g.text);
        this.aQn = (ImageView) this.layoutView.findViewById(e.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(e.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View aNz() {
        return this.divider;
    }
}
