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
    private ImageView dTO;
    private View dvw;
    private TextView iht;
    private View layoutView;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.layoutView = null;
        this.iht = null;
        this.dTO = null;
        this.dvw = null;
        initUI();
    }

    public View bqa() {
        return this.layoutView;
    }

    public void Eo(String str) {
        this.iht.setText(str);
    }

    public void ow(boolean z) {
        this.dTO.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.layoutView = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.iht = (TextView) this.layoutView.findViewById(R.id.text);
        this.dTO = (ImageView) this.layoutView.findViewById(R.id.group_address_list_item_selected);
        this.dvw = this.layoutView.findViewById(R.id.group_address_list_item_divider);
        this.layoutView.setTag(this);
    }

    public View cdD() {
        return this.dvw;
    }
}
