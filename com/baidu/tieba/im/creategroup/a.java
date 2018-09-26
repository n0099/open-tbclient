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
    private ImageView aLL;
    private View divider;
    private TextView evv;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.evv = null;
        this.aLL = null;
        this.divider = null;
        initUI();
    }

    public View aiP() {
        return this.layoutView;
    }

    public void oy(String str) {
        this.evv.setText(str);
    }

    public void hI(boolean z) {
        this.aLL.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.address_lbs_item, (ViewGroup) null);
        this.evv = (TextView) this.layoutView.findViewById(e.g.text);
        this.aLL = (ImageView) this.layoutView.findViewById(e.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(e.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View aKj() {
        return this.divider;
    }
}
