package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private View abp;
    private TextView ddv;
    private TextView ddw;
    private TextView ddx;
    private Context mContext;

    public BawuManagerApplyInfoView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public BawuManagerApplyInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public BawuManagerApplyInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.abp = LayoutInflater.from(this.mContext).inflate(d.i.bawu_manager_apply_layout, this);
        this.ddv = (TextView) this.abp.findViewById(d.g.imageview_apply_btn);
        this.ddw = (TextView) this.abp.findViewById(d.g.textview_manager_apply);
        this.ddx = (TextView) this.abp.findViewById(d.g.textview_manager_left_num);
    }

    public void X(String str, int i) {
        this.ddw.setText(str);
        if (i > 0) {
            this.ddx.setText(String.format(this.mContext.getResources().getString(d.k.apply_left_num_tip), ao.y(i)));
            this.ddv.setEnabled(true);
            this.ddv.setClickable(true);
            al.c(this.ddw, d.C0141d.cp_link_tip_a, 1);
            al.c(this.ddx, d.C0141d.cp_cont_d, 1);
            al.i(this.ddv, d.f.bg_manager_apply);
            return;
        }
        this.ddx.setText(this.mContext.getResources().getString(d.k.apply_no_left_tip));
        this.ddv.setEnabled(false);
        this.ddv.setClickable(false);
        al.c(this.ddw, d.C0141d.cp_cont_d, 1);
        al.c(this.ddx, d.C0141d.cp_cont_d, 1);
        al.i(this.ddv, d.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ddv.setOnClickListener(onClickListener);
    }
}
