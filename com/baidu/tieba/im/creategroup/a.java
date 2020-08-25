package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class a extends com.baidu.adp.base.c<BaseActivity> {
    private ImageView eHA;
    private View efZ;
    private TextView jjY;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.jjY = null;
        this.eHA = null;
        this.efZ = null;
        initUI();
    }

    public View bLz() {
        return this.layoutView;
    }

    public void Kf(String str) {
        this.jjY.setText(str);
    }

    public void qo(boolean z) {
        this.eHA.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.jjY = (TextView) this.layoutView.findViewById(R.id.text);
        this.eHA = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.efZ = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View cCx() {
        return this.efZ;
    }
}
