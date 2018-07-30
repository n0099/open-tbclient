package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private View aaV;
    private TextView did;
    private TextView die;
    private TextView dif;
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
        this.aaV = LayoutInflater.from(this.mContext).inflate(d.h.bawu_manager_apply_layout, this);
        this.did = (TextView) this.aaV.findViewById(d.g.imageview_apply_btn);
        this.die = (TextView) this.aaV.findViewById(d.g.textview_manager_apply);
        this.dif = (TextView) this.aaV.findViewById(d.g.textview_manager_left_num);
    }

    public void R(String str, int i) {
        this.die.setText(str);
        if (i > 0) {
            this.dif.setText(String.format(this.mContext.getResources().getString(d.j.apply_left_num_tip), ap.A(i)));
            this.did.setEnabled(true);
            this.did.setClickable(true);
            am.c(this.die, d.C0140d.cp_link_tip_a, 1);
            am.c(this.dif, d.C0140d.cp_cont_d, 1);
            am.i(this.did, d.f.bg_manager_apply);
            return;
        }
        this.dif.setText(this.mContext.getResources().getString(d.j.apply_no_left_tip));
        this.did.setEnabled(false);
        this.did.setClickable(false);
        am.c(this.die, d.C0140d.cp_cont_d, 1);
        am.c(this.dif, d.C0140d.cp_cont_d, 1);
        am.i(this.did, d.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.did.setOnClickListener(onClickListener);
    }
}
