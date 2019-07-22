package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private ImageView ahs;
    private View divider;
    private TextView gCn;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.gCn = null;
        this.ahs = null;
        this.divider = null;
        initUI();
    }

    public View aWR() {
        return this.layoutView;
    }

    public void yA(String str) {
        this.gCn.setText(str);
    }

    public void lT(boolean z) {
        this.ahs.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.gCn = (TextView) this.layoutView.findViewById(R.id.text);
        this.ahs = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.divider = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View bAX() {
        return this.divider;
    }
}
