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
    private View cVU;
    private ImageView dtB;
    private TextView hwa;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.hwa = null;
        this.dtB = null;
        this.cVU = null;
        initUI();
    }

    public View bgG() {
        return this.layoutView;
    }

    public void CD(String str) {
        this.hwa.setText(str);
    }

    public void nm(boolean z) {
        this.dtB.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.hwa = (TextView) this.layoutView.findViewById(R.id.text);
        this.dtB = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.cVU = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View bSM() {
        return this.cVU;
    }
}
