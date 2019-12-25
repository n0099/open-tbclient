package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private View cRG;
    private ImageView doU;
    private TextView hqk;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.hqk = null;
        this.doU = null;
        this.cRG = null;
        initUI();
    }

    public View bdY() {
        return this.layoutView;
    }

    public void Cc(String str) {
        this.hqk.setText(str);
    }

    public void mY(boolean z) {
        this.doU.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.hqk = (TextView) this.layoutView.findViewById(R.id.text);
        this.doU = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.cRG = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View bPZ() {
        return this.cRG;
    }
}
