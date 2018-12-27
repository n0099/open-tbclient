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
    private View amM;
    private TextView dGB;
    private TextView dGC;
    private TextView dGD;
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
        this.amM = LayoutInflater.from(this.mContext).inflate(e.h.bawu_manager_apply_layout, this);
        this.dGB = (TextView) this.amM.findViewById(e.g.imageview_apply_btn);
        this.dGC = (TextView) this.amM.findViewById(e.g.textview_manager_apply);
        this.dGD = (TextView) this.amM.findViewById(e.g.textview_manager_left_num);
    }

    public void ac(String str, int i) {
        this.dGC.setText(str);
        if (i > 0) {
            this.dGD.setText(String.format(this.mContext.getResources().getString(e.j.apply_left_num_tip), ao.Q(i)));
            this.dGB.setEnabled(true);
            this.dGB.setClickable(true);
            al.c(this.dGC, e.d.cp_link_tip_a, 1);
            al.c(this.dGD, e.d.cp_cont_d, 1);
            al.i(this.dGB, e.f.bg_manager_apply);
            return;
        }
        this.dGD.setText(this.mContext.getResources().getString(e.j.apply_no_left_tip));
        this.dGB.setEnabled(false);
        this.dGB.setClickable(false);
        al.c(this.dGC, e.d.cp_cont_d, 1);
        al.c(this.dGD, e.d.cp_cont_d, 1);
        al.i(this.dGB, e.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dGB.setOnClickListener(onClickListener);
    }
}
