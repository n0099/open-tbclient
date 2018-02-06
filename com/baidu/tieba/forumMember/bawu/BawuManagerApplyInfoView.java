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
    private View aId;
    private TextView dAF;
    private TextView dAG;
    private TextView dAH;
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
        this.aId = LayoutInflater.from(this.mContext).inflate(d.h.bawu_manager_apply_layout, this);
        this.dAF = (TextView) this.aId.findViewById(d.g.imageview_apply_btn);
        this.dAG = (TextView) this.aId.findViewById(d.g.textview_manager_apply);
        this.dAH = (TextView) this.aId.findViewById(d.g.textview_manager_left_num);
    }

    public void V(String str, int i) {
        this.dAG.setText(str);
        if (i > 0) {
            this.dAH.setText(String.format(this.mContext.getResources().getString(d.j.apply_left_num_tip), am.C(i)));
            this.dAF.setEnabled(true);
            this.dAF.setClickable(true);
            aj.e(this.dAG, d.C0140d.cp_link_tip_a, 1);
            aj.e(this.dAH, d.C0140d.cp_cont_d, 1);
            aj.s(this.dAF, d.f.bg_manager_apply);
            return;
        }
        this.dAH.setText(this.mContext.getResources().getString(d.j.apply_no_left_tip));
        this.dAF.setEnabled(false);
        this.dAF.setClickable(false);
        aj.e(this.dAG, d.C0140d.cp_cont_d, 1);
        aj.e(this.dAH, d.C0140d.cp_cont_d, 1);
        aj.s(this.dAF, d.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dAF.setOnClickListener(onClickListener);
    }
}
