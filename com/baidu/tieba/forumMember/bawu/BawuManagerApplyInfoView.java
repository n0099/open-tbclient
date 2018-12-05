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
    private TextView dDN;
    private TextView dDO;
    private TextView dDP;
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
        this.dDN = (TextView) this.amM.findViewById(e.g.imageview_apply_btn);
        this.dDO = (TextView) this.amM.findViewById(e.g.textview_manager_apply);
        this.dDP = (TextView) this.amM.findViewById(e.g.textview_manager_left_num);
    }

    public void ab(String str, int i) {
        this.dDO.setText(str);
        if (i > 0) {
            this.dDP.setText(String.format(this.mContext.getResources().getString(e.j.apply_left_num_tip), ao.P(i)));
            this.dDN.setEnabled(true);
            this.dDN.setClickable(true);
            al.c(this.dDO, e.d.cp_link_tip_a, 1);
            al.c(this.dDP, e.d.cp_cont_d, 1);
            al.i(this.dDN, e.f.bg_manager_apply);
            return;
        }
        this.dDP.setText(this.mContext.getResources().getString(e.j.apply_no_left_tip));
        this.dDN.setEnabled(false);
        this.dDN.setClickable(false);
        al.c(this.dDO, e.d.cp_cont_d, 1);
        al.c(this.dDP, e.d.cp_cont_d, 1);
        al.i(this.dDN, e.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dDN.setOnClickListener(onClickListener);
    }
}
