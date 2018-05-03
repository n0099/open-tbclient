package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private View Tl;
    private TextView cTf;
    private TextView cTg;
    private TextView cTh;
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
        this.Tl = LayoutInflater.from(this.mContext).inflate(d.i.bawu_manager_apply_layout, this);
        this.cTf = (TextView) this.Tl.findViewById(d.g.imageview_apply_btn);
        this.cTg = (TextView) this.Tl.findViewById(d.g.textview_manager_apply);
        this.cTh = (TextView) this.Tl.findViewById(d.g.textview_manager_left_num);
    }

    public void V(String str, int i) {
        this.cTg.setText(str);
        if (i > 0) {
            this.cTh.setText(String.format(this.mContext.getResources().getString(d.k.apply_left_num_tip), an.v(i)));
            this.cTf.setEnabled(true);
            this.cTf.setClickable(true);
            ak.c(this.cTg, d.C0126d.cp_link_tip_a, 1);
            ak.c(this.cTh, d.C0126d.cp_cont_d, 1);
            ak.i(this.cTf, d.f.bg_manager_apply);
            return;
        }
        this.cTh.setText(this.mContext.getResources().getString(d.k.apply_no_left_tip));
        this.cTf.setEnabled(false);
        this.cTf.setClickable(false);
        ak.c(this.cTg, d.C0126d.cp_cont_d, 1);
        ak.c(this.cTh, d.C0126d.cp_cont_d, 1);
        ak.i(this.cTf, d.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cTf.setOnClickListener(onClickListener);
    }
}
