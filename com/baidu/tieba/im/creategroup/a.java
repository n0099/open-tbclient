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
    private ImageView azf;
    private TextView dUd;
    private View divider;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.dUd = null;
        this.azf = null;
        this.divider = null;
        initUI();
    }

    public View acD() {
        return this.layoutView;
    }

    public void mX(String str) {
        this.dUd.setText(str);
    }

    public void gQ(boolean z) {
        this.azf.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(d.i.address_lbs_item, (ViewGroup) null);
        this.dUd = (TextView) this.layoutView.findViewById(d.g.text);
        this.azf = (ImageView) this.layoutView.findViewById(d.g.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(d.g.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View aBx() {
        return this.divider;
    }
}
