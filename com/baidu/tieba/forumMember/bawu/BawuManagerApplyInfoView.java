package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private View aHS;
    private TextView dAt;
    private TextView dAu;
    private TextView dAv;
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
        this.aHS = LayoutInflater.from(this.mContext).inflate(d.h.bawu_manager_apply_layout, this);
        this.dAt = (TextView) this.aHS.findViewById(d.g.imageview_apply_btn);
        this.dAu = (TextView) this.aHS.findViewById(d.g.textview_manager_apply);
        this.dAv = (TextView) this.aHS.findViewById(d.g.textview_manager_left_num);
    }

    public void V(String str, int i) {
        this.dAu.setText(str);
        if (i > 0) {
            this.dAv.setText(String.format(this.mContext.getResources().getString(d.j.apply_left_num_tip), am.C(i)));
            this.dAt.setEnabled(true);
            this.dAt.setClickable(true);
            aj.e(this.dAu, d.C0141d.cp_link_tip_a, 1);
            aj.e(this.dAv, d.C0141d.cp_cont_d, 1);
            aj.s(this.dAt, d.f.bg_manager_apply);
            return;
        }
        this.dAv.setText(this.mContext.getResources().getString(d.j.apply_no_left_tip));
        this.dAt.setEnabled(false);
        this.dAt.setClickable(false);
        aj.e(this.dAu, d.C0141d.cp_cont_d, 1);
        aj.e(this.dAv, d.C0141d.cp_cont_d, 1);
        aj.s(this.dAt, d.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dAt.setOnClickListener(onClickListener);
    }
}
