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
    private View adA;
    private TextView dnT;
    private TextView dnU;
    private TextView dnV;
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
        this.adA = LayoutInflater.from(this.mContext).inflate(e.h.bawu_manager_apply_layout, this);
        this.dnT = (TextView) this.adA.findViewById(e.g.imageview_apply_btn);
        this.dnU = (TextView) this.adA.findViewById(e.g.textview_manager_apply);
        this.dnV = (TextView) this.adA.findViewById(e.g.textview_manager_left_num);
    }

    public void W(String str, int i) {
        this.dnU.setText(str);
        if (i > 0) {
            this.dnV.setText(String.format(this.mContext.getResources().getString(e.j.apply_left_num_tip), ao.E(i)));
            this.dnT.setEnabled(true);
            this.dnT.setClickable(true);
            al.c(this.dnU, e.d.cp_link_tip_a, 1);
            al.c(this.dnV, e.d.cp_cont_d, 1);
            al.i(this.dnT, e.f.bg_manager_apply);
            return;
        }
        this.dnV.setText(this.mContext.getResources().getString(e.j.apply_no_left_tip));
        this.dnT.setEnabled(false);
        this.dnT.setClickable(false);
        al.c(this.dnU, e.d.cp_cont_d, 1);
        al.c(this.dnV, e.d.cp_cont_d, 1);
        al.i(this.dnT, e.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dnT.setOnClickListener(onClickListener);
    }
}
