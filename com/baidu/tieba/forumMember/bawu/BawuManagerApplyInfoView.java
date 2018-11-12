package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private View ajk;
    private TextView dxo;
    private TextView dxp;
    private TextView dxq;
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
        this.ajk = LayoutInflater.from(this.mContext).inflate(e.h.bawu_manager_apply_layout, this);
        this.dxo = (TextView) this.ajk.findViewById(e.g.imageview_apply_btn);
        this.dxp = (TextView) this.ajk.findViewById(e.g.textview_manager_apply);
        this.dxq = (TextView) this.ajk.findViewById(e.g.textview_manager_left_num);
    }

    public void aa(String str, int i) {
        this.dxp.setText(str);
        if (i > 0) {
            this.dxq.setText(String.format(this.mContext.getResources().getString(e.j.apply_left_num_tip), ao.I(i)));
            this.dxo.setEnabled(true);
            this.dxo.setClickable(true);
            al.c(this.dxp, e.d.cp_link_tip_a, 1);
            al.c(this.dxq, e.d.cp_cont_d, 1);
            al.i(this.dxo, e.f.bg_manager_apply);
            return;
        }
        this.dxq.setText(this.mContext.getResources().getString(e.j.apply_no_left_tip));
        this.dxo.setEnabled(false);
        this.dxo.setClickable(false);
        al.c(this.dxp, e.d.cp_cont_d, 1);
        al.c(this.dxq, e.d.cp_cont_d, 1);
        al.i(this.dxo, e.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dxo.setOnClickListener(onClickListener);
    }
}
