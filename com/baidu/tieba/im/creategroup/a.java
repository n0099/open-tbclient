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
    private View cVS;
    private ImageView dtn;
    private TextView hvM;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.hvM = null;
        this.dtn = null;
        this.cVS = null;
        initUI();
    }

    public View bgD() {
        return this.layoutView;
    }

    public void CC(String str) {
        this.hvM.setText(str);
    }

    public void nm(boolean z) {
        this.dtn.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.hvM = (TextView) this.layoutView.findViewById(R.id.text);
        this.dtn = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.cVS = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View bSJ() {
        return this.cVS;
    }
}
