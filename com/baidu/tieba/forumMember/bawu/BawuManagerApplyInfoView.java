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
    private View ano;
    private TextView dHk;
    private TextView dHl;
    private TextView dHm;
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
        this.ano = LayoutInflater.from(this.mContext).inflate(e.h.bawu_manager_apply_layout, this);
        this.dHk = (TextView) this.ano.findViewById(e.g.imageview_apply_btn);
        this.dHl = (TextView) this.ano.findViewById(e.g.textview_manager_apply);
        this.dHm = (TextView) this.ano.findViewById(e.g.textview_manager_left_num);
    }

    public void ac(String str, int i) {
        this.dHl.setText(str);
        if (i > 0) {
            this.dHm.setText(String.format(this.mContext.getResources().getString(e.j.apply_left_num_tip), ao.Q(i)));
            this.dHk.setEnabled(true);
            this.dHk.setClickable(true);
            al.c(this.dHl, e.d.cp_link_tip_a, 1);
            al.c(this.dHm, e.d.cp_cont_d, 1);
            al.i(this.dHk, e.f.bg_manager_apply);
            return;
        }
        this.dHm.setText(this.mContext.getResources().getString(e.j.apply_no_left_tip));
        this.dHk.setEnabled(false);
        this.dHk.setClickable(false);
        al.c(this.dHl, e.d.cp_cont_d, 1);
        al.c(this.dHm, e.d.cp_cont_d, 1);
        al.i(this.dHk, e.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dHk.setOnClickListener(onClickListener);
    }
}
